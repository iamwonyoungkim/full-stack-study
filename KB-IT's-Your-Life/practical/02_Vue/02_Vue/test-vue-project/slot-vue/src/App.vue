<template>
  <button @click="currentLayout = 'BaseLayout1'">레이아웃 1</button>
  <button @click="currentLayout = 'BaseLayout2'">레이아웃 2</button>
  <keep-alive>
    <component :is="currentLayout"></component>
  </keep-alive>
</template>
<script>
import BaseLayout1 from './components/BaseLayout1.vue';
import BaseLayout2 from './components/BaseLayout2.vue';

export default {
  name: 'App',
  components: { BaseLayout1, BaseLayout2 },
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
