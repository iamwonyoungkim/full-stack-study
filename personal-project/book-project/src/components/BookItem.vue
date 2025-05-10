<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">{{ book.volumeInfo.title }}</h5>
      <router-link :to="`/book/${book.id}`" class="btn btn-outline-primary me-3"
        >상세 보기</router-link
      >
      <button
        class="btn"
        :class="isFav ? 'btn-danger' : 'btn-outline-primary'"
        @click="toggleFavourite"
      >
        {{ isFav ? '즐겨찾기 제거' : '즐겨찾기 추가' }}
      </button>
    </div>
  </div>
</template>

<script setup>
import { useFavouritesStore } from '@/stores/favouritesStore';
import { computed } from 'vue';

// props는 부모 컴포넌트가 자식 컴포넌트에 데이터를 전달하는 방법이다.
/*
    부모 컴포넌트(SearchPage.vue)에서 <BookItem :book="book" />
        - 여기서 book은 props 이름이자,
        - :book="book"은 book이라는 데이터를 자식에게 넘겨준다는 뜻이다.
        - :book은 자식 컴포넌트의 props 이름, "book"은 현재 부모 컴포넌트 내부의 변수(book)이다.
    자식 컴포넌트(BookItem.vue)에서는 defineProps({ book: Object }) 이렇게 받는다.
        - 이렇게 하면 book이라는 이름의 prop을 받을 수 있다.
*/
const props = defineProps({
  book: Object,
});
/*
setup이 아닌 기본 <script>에서
export default {
    props: {
        book: Object
    }
}
와 동일한 역할을 한다.
*/
const favouritesStore = useFavouritesStore();

// 현재 책이 즐겨찾기에 있는지 여부
// computed를 이용하여 favouritesStore.favourites의 값이 변경될 때마다 isFav.valu도 자동으로 갱신된다.
// 즉, 즐겨찾기 목록이 바뀌면, 해당 도서가 즐겨찾기에 있는지 아닌지도 자동으로 업데이트되고, UI가 바로 반응한다.
const isFav = computed(() => favouritesStore.isFavourite(props.book.id));

const toggleFavourite = () => {
  if (isFav.value) {
    favouritesStore.removeFavourite(props.book.id);
  } else {
    favouritesStore.addFavourite(props.book);
  }
};
</script>
