<script setup>
const props = defineProps({
  travel: { Type: Object, required: true },
});

console.log(props.travel.images);
const background = {
  // 첫 번째 이미지를 배경 이미지로 설정 (css의 background-image)
  backgroundImage: `url('${props.travel.images[0].url}')`,
};
</script>

<template>
  <!-- 수평 중앙 정렬 -->
  <div
    class="travel-header mb-4 d-flex justify-content-center"
    :style="background"
  >
    <!-- 수직중앙정렬 -->
    <h1 class="align-content-center">
      [{{ travel.district }}] {{ travel.title }}
    </h1>
  </div>
</template>

<style scoped>
.travel-header {
  height: 300px;
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
  color: white;
}
</style>
