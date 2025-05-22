<template>
  <div>
    <button @click="recommendBook()">클릭하세요</button>
  </div>
</template>

<script>
export default {
  name: 'BookItem',
  props: ['title', 'author'],
  methods: {
    recommendBook() {
      this.$emit('recommend', 'Harry Potter');
    },
  },
};
</script>
