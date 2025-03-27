<!-- ContentCard.vue -->
<template>
  <div class="content-card">
    <h2>{{ title }}</h2>
    <p>{{ description }}</p>
    <button @click="handleClick">자세히 보기</button>
  </div>
</template>

<script>
export default {
  name: 'ContentCard',
  props: {
    title: {
      type: String,
      default: '카드 제목',
    },
    description: {
      type: String,
      default: '카드 설명',
    },
  },
  methods: {
    handleClick() {
      this.$emit('click');
    },
  },
};
</script>

<style scoped>
.content-card {
  padding: 1rem;
  margin: 1rem;
  border: 1px solid #ddd;
  border-radius: 8px;
}
</style>
