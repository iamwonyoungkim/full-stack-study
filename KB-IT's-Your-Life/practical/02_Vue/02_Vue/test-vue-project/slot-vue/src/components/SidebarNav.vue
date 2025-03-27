<!-- SidebarNav.vue -->
<template>
  <div class="sidebar-nav">
    <h3>네비게이션</h3>
    <ul>
      <li v-for="item in navItems" :key="item.id">
        <a :href="item.link">{{ item.text }}</a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'SidebarNav',
  data() {
    return {
      navItems: [
        { id: 1, text: '대시보드', link: '#' },
        { id: 2, text: '프로필', link: '#' },
        { id: 3, text: '설정', link: '#' },
      ],
    };
  },
};
</script>

<style scoped>
.sidebar-nav {
  padding: 1rem;
  background-color: #f1f1f1;
}
</style>
