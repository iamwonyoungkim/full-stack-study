<script setup>
import MenuItem from './MenuItem.vue';
const props = defineProps({
  menus: { Type: Array, required: true },
});
</script>

<template>
  <ul class="navbar-nav">
    <!-- 
    이 경우에는 menus 배열이 변하지 않으므로 key가 필요x
    동적으로 메뉴가 추가되거나 삭제되는 경우에는 key를 지정해줘야 한다.
    예) :key="menu.id"
    -->
    <MenuItem v-for="menu in menus" :menu="menu" />
  </ul>
</template>
