<template>
  <div v-if="book">
    {{ book.id }} {{ book.title }} {{ book.author }}
    <img :src="book.image" />
  </div>
</template>

<script>
import booksData from '@/books.json';

export default {
  name: 'BookDetail',
  // BookList에서 보내준 id
  props: ['id'],
  computed: {
    book() {
      console.log('Route params:', this.$route.params);
      return booksData.books.find(
        (book) =>
          // this.id가 위의 props에 define되어 있는 id이다.
          // book.id === this.id; parseInt로 숫자로 바꿔준다
          book.id === parseInt(this.id)
        // props를 쓰지 않으면 아래와 같이 해야 한다.
        // book.id === parseInt(this.$route.params.id)
      );
    },
  },
};
</script>
