<template>
  <h1>도서 목록</h1>
  <div class="sort-options">
    <fieldset>
      <legend>정렬 기준</legend>
      <div class="radio-group">
        <input type="radio" v-model="sortBy" value="title" checked />
        제목
        <input type="radio" v-model="sortBy" value="author" />
        저자
        <input type="radio" v-model="sortBy" value="price" />
        가격
      </div>
    </fieldset>
  </div>
  <div v-if="error">{{ error }}</div>
  <div v-if="getBooks.length === 0" class="no-books">
    조회된 목록이 없습니다.
  </div>
  <div v-for="book in getBooks" :key="book.id">
    <h3>{{ book.title }}</h3>
    <p>저자: {{ book.author }}</p>
    <p>가격: {{ book.price }}원</p>
    <hr />
  </div>
</template>

<script setup>
import { useBookStore } from '@/stores/book';
import { ref, watch, computed } from 'vue';

const store = useBookStore();
const { getBooks, fetchBooks } = store;
const error = computed(() => store.getError);

const sortBy = ref('title');

fetchBooks(sortBy.value);

watch(sortBy, (newVal) => {
  fetchBooks(newVal);
});
</script>
