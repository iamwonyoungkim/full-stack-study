<template>
  <div>
    <h3>탭 A 내용</h3>
    <input v-model="message" placeholder="메시지 입력" />
    <p>입력값: {{ message }}</p>
  </div>
</template>
<script>
export default {
  name: 'TabA',
  data() {
    return {
      message: '',
    };
  },
  created() {
    console.log('탭 A 생성됨');
  },
  unmounted() {
    console.log('탭 A 제거됨');
  },
};
</script>
