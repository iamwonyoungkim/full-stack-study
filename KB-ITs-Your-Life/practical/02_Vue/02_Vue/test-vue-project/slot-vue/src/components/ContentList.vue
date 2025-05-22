<!-- ContentList.vue -->
<template>
  <div class="content-list">
    <h2>{{ listTitle }}</h2>
    <ul>
      <li v-for="item in items" :key="item.id">
        {{ item.text }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'ContentList',
  props: {
    listTitle: {
      type: String,
      default: '목록',
    },
    items: {
      type: Array,
      default: () => [],
    },
  },
};
</script>

<style scoped>
.content-list {
  padding: 1rem;
  margin: 1rem;
}
</style>
