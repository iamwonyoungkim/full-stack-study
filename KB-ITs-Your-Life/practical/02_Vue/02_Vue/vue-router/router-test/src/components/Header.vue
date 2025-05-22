<template>
  <header>
    <nav>
      <!-- a 링크 이용하지 마세요!!! -->
      <!-- <router-link to="/">Home</router-link>
      <router-link to="/about">About</router-link>
      <router-link to="/contact">Contact</router-link> -->

      <router-link :to="{ name: 'BookList' }">BookList</router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: 'Header',
};
</script>
