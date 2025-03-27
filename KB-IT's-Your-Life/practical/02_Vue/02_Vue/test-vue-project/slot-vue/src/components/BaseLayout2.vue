<template>
  <Header />
  <div class="row">
    <div class="col">
      <SidebarNav />
    </div>
    <div class="col">
      <ContentCard />
      <ContentList :items="$parent.listItems" />
      <ContentGrid />
    </div>
    <div class="col">
      <SidebarWidget />
    </div>
  </div>

  <Footer />
</template>

<script>
import Header from './Header.vue';
import SidebarNav from './SidebarNav.vue';
import SidebarWidget from './SidebarWidget.vue';
import ContentCard from './ContentCard.vue';
import ContentList from './ContentList.vue';
import ContentGrid from './ContentGrid.vue';
import Footer from './Footer.vue';

export default {
  name: 'BaseLayout2',
  components: {
    Header,
    SidebarNav,
    SidebarWidget,
    ContentCard,
    ContentList,
    ContentGrid,
    Footer,
  },
  data() {},
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
