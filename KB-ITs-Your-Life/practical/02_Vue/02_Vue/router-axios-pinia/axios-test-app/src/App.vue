<template>
  <router-link :to="{ name: 'BookList' }">도서 목록</router-link>
  <router-view></router-view>
  <Loading v-if="isLoading === true" />
</template>
<script setup>
import { computed } from 'vue';
import Loading from './components/Loading.vue';
import { useBookStore } from '@/stores/book.js';

const store = useBookStore();
const isLoading = computed(() => store.getIsLoading);
</script>
