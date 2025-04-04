import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0);
  const doubleCount = computed(() => count.value * 2);
  function increment() {
    count.value++;
  }

  // 다른 컴포넌트에서 상태에 접근하기 위해 쓸 수 있는 것들
  return { count, doubleCount, increment };
});
