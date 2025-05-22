<!-- SidebarWidget.vue -->
<template>
  <div class="sidebar-widget">
    <h3>최근 활동</h3>
    <ul>
      <li v-for="activity in recentActivities" :key="activity.id">
        {{ activity.text }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'SidebarWidget',
  data() {
    return {
      recentActivities: [
        { id: 1, text: '새로운 게시물 작성' },
        { id: 2, text: '댓글 업데이트' },
        { id: 3, text: '프로필 수정' },
      ],
    };
  },
};
</script>

<style scoped>
.sidebar-widget {
  padding: 1rem;
  margin-top: 1rem;
  background-color: #f8f9fa;
}
</style>
