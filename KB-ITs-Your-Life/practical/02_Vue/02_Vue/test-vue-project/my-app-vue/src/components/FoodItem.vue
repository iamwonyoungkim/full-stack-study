<template>
  <div>
    <button @click="suggestFood">음식 추천</button>
  </div>
</template>

<script>
export default {
  name: 'FoodItem',
  props: {
    // props 유효성 검증:
    food: {
      // 1. food는 Object 타입이어야 함
      type: Object,
      // 2. food는 필수 속성으로 반드시 전달되어야 함
      required: false,
    },
  },
  emits: ['toggle-cart'],
  data() {
    return {
      isSelected: false,
    };
  },
  methods: {
    toggleCart() {
      //이벤트 코드...

      this.$emit('toggle-cart', this.food, this.isSelected);
    },
  },
};
</script>

<style></style>
