<template>
  <div class="book-item">
    <h4>{{ title }}</h4>
    <p>저자: {{ author }}</p>
    <p>가격: {{ price }}</p>
    <button @click="selectBook">선택</button>
  </div>
</template>

<script>
export default {
  name: 'BookItem',
  props: ['title', 'author', 'price'],
  emits: ['select'],
  methods: {
    selectBook() {
      //아래를 한줄로 한다면 -> this.$emit('select', this.$props);
      this.$emit('select', {
        title: this.title,
        author: this.author,
        price: this.price,
      });
    },
  },
};
</script>
