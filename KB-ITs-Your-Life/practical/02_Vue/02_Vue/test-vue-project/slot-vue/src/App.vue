<template>
  <div id="app">
    <button @click="currentLayout = 'BaseLayout1'">레이아웃 1</button>
    <button @click="currentLayout = 'BaseLayout2'">레이아웃 2</button>

    <component :is="currentLayout">
      <template #header>
        <Header />
      </template>

      <template #sidebar v-if="currentLayout === 'BaseLayout1'">
        <SidebarNav />
        <SidebarWidget />
      </template>

      <template #left-sidebar v-if="currentLayout === 'BaseLayout2'">
        <SidebarNav />
      </template>

      <template #content>
        <ContentCard
          title="메인 컨텐츠"
          description="슬롯을 활용한 레이아웃 구성"
          @click="handleCardClick"
        />
        <ContentList listTitle="최근 소식" :items="listItems" />
        <ContentGrid :gridItems="gridItems" />
      </template>

      <template #right-sidebar v-if="currentLayout === 'BaseLayout2'">
        <SidebarWidget />
      </template>

      <template #footer>
        <Footer />
      </template>
    </component>
  </div>
</template>
<script>
import BaseLayout1 from './components/BaseLayout1.vue';
import BaseLayout2 from './components/BaseLayout2.vue';
import Header from './components/Header.vue';
import SidebarNav from './components/SidebarNav.vue';
import SidebarWidget from './components/SidebarWidget.vue';
import ContentCard from './components/ContentCard.vue';
import ContentList from './components/ContentList.vue';
import ContentGrid from './components/ContentGrid.vue';
import Footer from './components/Footer.vue';

export default {
  name: 'App',
  components: {
    BaseLayout1,
    BaseLayout2,
    Header,
    SidebarNav,
    SidebarWidget,
    ContentCard,
    ContentList,
    ContentGrid,
    Footer,
  },
  data() {
    return {
      currentLayout: 'BaseLayout1',
      listItems: [
        { id: 1, text: '새로운 소식 1' },
        { id: 2, text: '새로운 소식 2' },
        { id: 3, text: '새로운 소식 3' },
      ],
      gridItems: [
        {
          id: 1,
          title: '그리드 1',
          description: '설명 1',
          image: 'https://via.placeholder.com/300x200',
        },
        {
          id: 2,
          title: '그리드 2',
          description: '설명 2',
          image: 'https://via.placeholder.com/300x200',
        },
        {
          id: 3,
          title: '그리드 3',
          description: '설명 3',
          image: 'https://via.placeholder.com/300x200',
        },
      ],
    };
  },
  methods: {
    handleCardClick() {
      console.log('카드가 클릭되었습니다');
    },
  },
};
</script>

<style>
#app {
  font-family: Arial, sans-serif;
}
button {
  margin: 10px;
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: white;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
</style>
