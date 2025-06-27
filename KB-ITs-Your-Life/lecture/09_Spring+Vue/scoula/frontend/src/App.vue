<script setup>
import { RouterView } from 'vue-router';
import DefaultLayout from './components/layouts/DefaultLayout.vue';
</script>

<template>
  <DefaultLayout>
    <!-- 이게 DefaultLayout.vue의 slot 자리에 들어가게 된다. -->
    <RouterView />
  </DefaultLayout>
</template>

<style scoped></style>
