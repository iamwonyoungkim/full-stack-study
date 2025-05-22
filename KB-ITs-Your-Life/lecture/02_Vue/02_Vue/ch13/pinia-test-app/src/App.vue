<script setup>
import { useCounterStore } from '@/stores/counter.js';
import { computed } from 'vue';

const store = useCounterStore();
const { increment } = store;
// computed가 아닌, const {count} = store;로 하면 반응성을 잃어버린다.
const count = computed(() => store.count);

increment();
console.log(count);
</script>

<template>
  {{ store.count }}/{{ store.doubleCount }} <br />
  {{ count }}
</template>
