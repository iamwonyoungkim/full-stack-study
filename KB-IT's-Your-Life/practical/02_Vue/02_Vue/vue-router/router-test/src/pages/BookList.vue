<template>
  <ul v-for="book in books" :key="book.id">
    <li @click="goDetail(book.id)">{{ book.title }} - {{ book.author }}</li>
  </ul>
</template>
<script>
import booksData from '@/books.json';

export default {
  name: 'BookList',
  data() {
    // json 파일에서 데이터를 가져온다.
    return { books: booksData.books };
  },
  methods: {
    goDetail(id) {
      // 화면(<router-view/>을 BookDeatil로 바꾼다
      // params로 어떤 책을 보여줘야 할지 BookDetail한테 보내준다.
      this.$router.push({ name: 'BookDetail', params: { id: id } });
    },
  },
};
</script>
