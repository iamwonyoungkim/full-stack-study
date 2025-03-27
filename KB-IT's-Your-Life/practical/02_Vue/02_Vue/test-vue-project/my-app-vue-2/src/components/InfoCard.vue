<template>
  <slot name="header" :title="title">기본헤더</slot>
  <slot name="items" :items="items"></slot>
  <slot name="footer" :date="date">기본푸터</slot>
</template>

<script>
export default {
  name: 'InfoCard',
  data() {
    return {
      title: '안내사항',
      date: '2025.03.26',
      items: ['항목1', '항목2', '항목3'],
    };
  },
};
</script>
