<template>
  <Header />
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
  name: 'BaseLayout1',
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
