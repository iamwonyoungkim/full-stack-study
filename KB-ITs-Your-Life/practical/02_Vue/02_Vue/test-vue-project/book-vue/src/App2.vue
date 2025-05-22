<template>
  <div class="app">
    <h1>{{ title }}</h1>
    <div class="book-list">
      <BookItem
        v-for="book in books"
        :key="book.id"
        :title="book.title"
        :author="book.author"
        :price="book.price"
        @select="onSelect"
      />
    </div>
    <div v-if="hasSelectedBook" class="info">
      <h3>선택된 도서</h3>
      <p>제목: {{ pickedBook.title }}</p>
      <p>저자: {{ pickedBook.author }}</p>
      <p>가격: {{ pickedBook.price }}원</p>
      <small
        ><p v-if="previousBook">이전 선택: {{ previousBook.title }}</p></small
      >
    </div>
  </div>
</template>

<script>
import { ref, computed, watch, onMounted } from 'vue';
import BookItem from './components/BookItem.vue';

export default {
  name: 'App',
  components: {
    BookItem,
  },
  setup() {
    const title = ref('도서 목록');
    const pickedBook = ref(null);
    const previousBook = ref(null);
    const books = ref([
      { id: 1, title: '자바스크립트', author: '김개발', price: 25000 },
      { id: 2, title: '파이썬', author: '이코딩', price: 30000 },
      { id: 3, title: 'Vue.js', author: '박웹', price: 28000 },
    ]);
    const hasSelectedBook = computed(() => pickedBook.value !== null);
    watch(pickedBook, (newBook, oldBook) => {
      if (oldBook) {
        previousBook.value = oldBook;
      }
    });
    function onSelect(book) {
      pickedBook.value = book;
      log();
    }
    function log() {
      console.log(`선택된 도서: ${pickedBook.value.title}`);
    }
    onMounted(() => {
      books.value.forEach((book) => {
        console.log('도서 정보:', book.title, book.author, book.price);
      });
    });
    return {
      title,
      pickedBook,
      previousBook,
      books,
      hasSelectedBook,
      onSelect,
    };
  },
};
</script>
