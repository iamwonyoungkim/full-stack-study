<template>
  <!-- 여기에 체크박스와 음식 정보를 표시하는 템플릿 작성 -->
  <li>
    <input @change="toggleCart" type="checkbox" :checked="food.isSelected" />{{
      food.name
    }}
    - {{ food.price }}원
  </li>
</template>
<script>
export default {
  name: 'FoodItem',
  // props 정의: food 객체 (필수)
  props: ['food'],
  data() {
    // 체크박스 상태를 저장할 데이터
    return {
      isSelected: false,
    };
  },
  methods: {
    // 체크박스 상태 변경시 호출될 메소드
    // 부모 컴포넌트에 선택 상태와 음식 정보를 전달
    toggleCart() {
      this.isSelected = !this.isSelected;
      this.$emit('toggle-cart', this.food, this.isSelected);
    },
  },
};
</script>
