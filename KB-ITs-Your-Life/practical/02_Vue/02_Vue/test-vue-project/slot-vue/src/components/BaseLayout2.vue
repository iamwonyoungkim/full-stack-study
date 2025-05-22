<template>
  <div class="layout">
    <header class="header">
      <slot name="header"></slot>
    </header>
    <div class="main-content">
      <aside class="sidebar">
        <slot name="sidebar"></slot>
      </aside>
      <main class="content">
        <slot name="content"></slot>
      </main>
    </div>
    <footer class="footer">
      <slot name="footer"></slot>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'BaseLayout2',
};
</script>

<style scoped>
.layout {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}
.main-content {
  display: grid;
  grid-template-columns: 250px 1fr 250px;
  gap: 20px;
  flex: 1;
  padding: 20px;
}
.left-sidebar,
.right-sidebar {
  background-color: #f8f9fa;
}
.content {
  padding: 20px;
}
</style>
