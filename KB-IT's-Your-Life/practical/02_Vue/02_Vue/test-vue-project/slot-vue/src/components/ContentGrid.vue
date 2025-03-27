<!-- ContentGrid.vue -->
<template>
  <div class="content-grid">
    <div v-for="item in gridItems" :key="item.id" class="grid-item">
      <img :src="item.image" :alt="item.title" />
      <h3>{{ item.title }}</h3>
      <p>{{ item.description }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ContentGrid',
  props: {
    gridItems: {
      type: Array,
      default: () => [],
    },
  },
};
</script>

<style scoped>
.content-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1rem;
  padding: 1rem;
}
</style>
