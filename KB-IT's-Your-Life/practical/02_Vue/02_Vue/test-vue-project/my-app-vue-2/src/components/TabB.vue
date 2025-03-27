<template>
  <div>
    <h3>탭 B 내용</h3>
    <input v-model="message" placeholder="다른 메시지 입력" />
    <p>입력값: {{ message }}</p>
  </div>
</template>
<script>
export default {
  name: 'TabB',
  data() {
    return {
      message: '',
    };
  },
  created() {
    console.log('탭 B 생성됨');
  },
  unmounted() {
    console.log('탭 B 제거됨');
  },
};
</script>
