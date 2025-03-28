<template>
  <!-- What I've done before -->
  <!-- <Header />
  <div class="row">
    <div class="col">
      <SidebarNav />
      <SidebarWidget />
    </div>
    <div class="col">
      <ContentCard />
      <ContentList />
      <ContentGrid />
    </div>
  </div>
  <Footer /> -->

  <!-- right way -->
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
  name: 'BaseLayout1',
};
</script>

<style scoped>
.layout {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}
.main-content {
  display: flex;
  flex: 1;
}
.sidebar {
  width: 250px;
  background-color: #f8f9fa;
}
.content {
  flex: 1;
  padding: 20px;
}
</style>
