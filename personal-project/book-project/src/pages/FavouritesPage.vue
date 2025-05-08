<template>
  <div class="container">
    <h1>⭐ 즐겨찾기한 도서</h1>
    <BookItem
      v-for="book in favouritesStore.favourites"
      :key="book.id"
      :book="book"
    />
    <p v-if="favouritesStore.favourites.length === 0">
      아직 즐겨찾기한 도서가 없습니다.
    </p>
  </div>
</template>

<script setup>
import BookItem from '@/components/BookItem.vue';
import { useFavouritesStore } from '@/stores/favouritesStore';

const favouritesStore = useFavouritesStore();
</script>
