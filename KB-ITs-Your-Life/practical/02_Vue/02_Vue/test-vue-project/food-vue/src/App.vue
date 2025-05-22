<template>
  <!--
  1. 음식 목록
  2. 장바구니
  3. 총 금액 표시
  -->
  <div>
    <h2>음식 목록</h2>
    <ul>
      <FoodItem
        @toggle-cart="toggleCartHandler"
        v-for="food in foodItems"
        :key="food.id"
        :food="food"
      />
    </ul>
  </div>
  <div>
    <h2>장바구니</h2>
    <ul v-for="cartItem in cartItems" :key="cartItem.id">
      <li>{{ cartItem.name }} - {{ cartItem.price }}원</li>
    </ul>
  </div>
  <div>
    <h2>총 금액: {{ totalPrice }}원</h2>
  </div>
</template>
<script>
// FoodItem 컴포넌트 불러오기
import FoodItem from './components/FoodItem.vue';

export default {
  name: 'App',
  components: {
    // 사용할 컴포넌트 등록
    FoodItem,
  },
  data() {
    return {
      // 음식 목록 데이터
      foodItems: [
        { id: 1, name: '사과', price: 5000, category: '과일' },
        { id: 2, name: '바나나', price: 3000, category: '과일' },
        { id: 3, name: '오렌지', price: 4000, category: '과일' },
      ],
      // 장바구니 데이터
      cartItems: [],
    };
  },
  computed: {
    totalPrice() {
      return this.cartItems.reduce((sum, item) => sum + item.price, 0);
    },
  },
  methods: {
    // 장바구니 업데이트 메소드
    // FoodItem에서 발생한 이벤트 처리
    toggleCartHandler(food, isSelected) {
      if (isSelected) {
        this.cartItems.push(food);
      } else {
        this.cartItems = this.cartItems.filter((item) => item.id !== food.id);
      }
    },
  },
};
</script>
