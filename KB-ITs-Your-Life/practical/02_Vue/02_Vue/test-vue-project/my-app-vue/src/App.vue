<template>
  <h1>여기는 App.vue</h1>
  <food-item @suggest="handleSuggest" />
  {{ suggested }}
  <br />
  <book-item @recommend="handleRecommend" />
  {{ recommended }}
</template>

<script>
import FoodItem from './components/FoodItem.vue';
import BookItem from './components/BookItem.vue';

export default {
  name: 'App',
  components: { FoodItem, BookItem },
  data() {
    return {
      suggested: '',
      recommended: '',
    };
  },
  methods: {
    handleSuggest(item) {
      this.suggested = item;
    },
    handleRecommend(item) {
      this.recommended = item;
    },
  },
};
</script>

<style scoped></style>
