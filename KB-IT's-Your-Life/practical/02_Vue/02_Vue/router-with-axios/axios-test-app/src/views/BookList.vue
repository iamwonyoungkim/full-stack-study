<template>
  <h1>도서 목록</h1>
  <div v-for="book in books" :key="book.id">
    <h3>{{ book.title }}</h3>
    <p>저자: {{ book.author }}</p>
    <p>가격: {{ book.price }}원</p>
    <hr />
  </div>
</template>
<script setup>
import axios from 'axios';
import { ref } from 'vue';

const books = ref([]);

const fetchBooks = async () => {
  try {
    const response = await axios.get('/api/books?_sort=id&_page=1&_per_page=3');
    console.log(response.data.data);
    books.value = response.data.data;
  } catch (error) {
    console.error('도서 목록 가져오기 실패:', error);
  }
};

fetchBooks();
</script>
