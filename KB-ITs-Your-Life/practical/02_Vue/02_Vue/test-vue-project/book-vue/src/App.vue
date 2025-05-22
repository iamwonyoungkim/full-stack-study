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
import BookItem from './components/BookItem.vue';

export default {
  name: 'App',
  components: {
    BookItem,
  },
  data() {
    return {
      title: '도서 목록',
      pickedBook: null,
      previousBook: null,
      books: [
        { id: 1, title: '자바스크립트', author: '김개발', price: 25000 },
        { id: 2, title: '파이썬', author: '이코딩', price: 30000 },
        { id: 3, title: 'Vue.js', author: '박웹', price: 28000 },
      ],
    };
  },
  // 코드 안에 반응형 data가 있는 경우,
  // computed 안의 hasSelectedBook을 새로운 변수 명으로 사용할 수 있게 한다.
  computed: {
    hasSelectedBook() {
      return this.pickedBook !== null;
    },
  },
  watch: {
    pickedBook(newBook, oldBook) {
      console.log(`선택된 도서: ${newBook.title}`);
      this.previousBook = oldBook;
    },
  },
  methods: {
    onSelect(book) {
      this.hasSelectedBook = true;
      this.pickedBook = book;
    },
  },
  mounted() {
    this.books.forEach((book) => {
      console.log(`도서 정보: ${book.title} ${book.author} ${book.price}`);
    });
  },
};
</script>

<style scoped>
.book-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.book-item {
  display: flex;
  align-items: center;
  gap: 20px;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.book-item h4 {
  margin: 0;
  min-width: 120px;
}

.book-item p {
  margin: 0;
  min-width: 100px;
}

.book-item button {
  margin-left: auto;
}
</style>
