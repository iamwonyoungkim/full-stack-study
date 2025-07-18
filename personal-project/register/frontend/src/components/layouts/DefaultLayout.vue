<script setup>
import Header from './Header.vue';
import NavBar from './NavBar.vue';
import Footer from './Footer.vue';
</script>

<template>
  <div class="container">
    <Header />
    <NavBar />
    <div class="content my-5 px-3">
      <!-- slot에 뭐가 올지는 부모가 결정한다. -->
      <slot></slot>
    </div>
    <Footer />
  </div>
</template>
