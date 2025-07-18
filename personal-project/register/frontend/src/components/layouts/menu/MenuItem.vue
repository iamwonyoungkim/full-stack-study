<script setup>
const props = defineProps({
  menu: { Type: Object, required: true },
});
</script>

<template>
  <li class="nav-item">
    <!-- 
    to="문자열"은 html 표준 
    :to="표현식"은 v-bind 
    -->
    <router-link class="nav-link" :to="menu.url">
      <i :class="menu.icon"></i>
      {{ menu.title }}
    </router-link>
  </li>
</template>

<style></style>
