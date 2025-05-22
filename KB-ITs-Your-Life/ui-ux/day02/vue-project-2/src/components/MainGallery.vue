<script setup>
import BaseButton from './UI/BaseButton.vue';
</script>
<template>
  <main class="component-grid">
    <!-- 컴포넌트 그룹 (그리드 아이템) -->
    <section class="component-card">
      <h2>버튼</h2>
      <BaseButton class="btn-primary">Primary</BaseButton>
      <BaseButton class="btn-outline">Outline</BaseButton>
      <BaseButton class="btn-pill">Pill</BaseButton>
    </section>
  </main>
</template>
<style scoped></style>
