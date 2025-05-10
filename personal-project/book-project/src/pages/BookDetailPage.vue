<template>
  <div class="container mt-4">
    <div v-if="book">
      <h2>{{ book.volumeInfo.title }}</h2>
      <p>
        <strong>저자:</strong>
        {{ book.volumeInfo.authors?.join(', ') || '저자 정보 없음' }}
      </p>
      <p><strong>출판사:</strong> {{ book.volumeInfo.publisher }}</p>
      <p><strong>설명:</strong> {{ book.volumeInfo.description }}</p>
      <button
        class="btn"
        :class="isFav ? 'btn-danger' : 'btn-outline-primary'"
        @click="toggleFavourite"
      >
        {{ isFav ? '즐겨찾기 제거' : '즐겨찾기 추가' }}
      </button>
    </div>
    <div v-else>
      <p>로딩 중...</p>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref, computed } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';
import { useFavouritesStore } from '@/stores/favouritesStore';

const route = useRoute();
const book = ref(null);

const favouritesStore = useFavouritesStore();

// 현재 책이 즐겨찾기에 있는지 여부
// computed를 이용하여 favouritesStore.favourites의 값이 변경될 때마다 isFav.value도 자동으로 갱신된다.
// 즉, 즐겨찾기 목록이 바뀌면, 해당 도서가 즐겨찾기에 있는지 아닌지도 자동으로 업데이트되고, UI가 바로 반응한다.
const isFav = computed(() =>
  book.value ? favouritesStore.isFavourite(book.value.id) : false
);

function toggleFavourite() {
  if (!book.value) return; // book이 없으면 아무것도 하지 않음
  if (isFav.value) {
    favouritesStore.removeFavourite(book.value.id);
  } else {
    favouritesStore.addFavourite(book.value);
  }
}

onMounted(async () => {
  const id = route.params.id;
  try {
    const response = await axios.get(
      `https://www.googleapis.com/books/v1/volumes/${id}`
    );
    book.value = response.data;
  } catch (error) {
    console.error('도서 정보를 불러오는 중 오류 발생:', error);
  }
});
</script>
