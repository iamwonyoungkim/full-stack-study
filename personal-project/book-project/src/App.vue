<template>
  <div>
    <nav class="navbar navbar-expand navbar-light bg-light px-3 mb-3">
      <router-link to="/" class="nav-link pe-3">도서 검색</router-link>
      <router-link to="/favourites" class="nav-link">즐겨찾기</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script setup>
import SearchPage from '@/pages/SearchPage.vue';
import FavouritesPage from './pages/FavouritesPage.vue';
</script>
