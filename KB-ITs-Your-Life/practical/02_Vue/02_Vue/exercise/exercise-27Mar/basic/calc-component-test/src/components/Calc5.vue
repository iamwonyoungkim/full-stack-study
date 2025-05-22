<template>
  <div>
    X : <input type="text" v-model.number="x" /> <br />
    <div>결과 : {{ result }}</div>
  </div>
</template>

<script>
import { ref, watch } from 'vue';

export default {
  name: 'Calc',
  setup() {
    const x = ref(0);
    const result = ref(0);

    watch(x, (newValue, oldValue) => {
      console.log(`이전 값: ${oldValue}, 새 값: ${newValue}`);
      result.value = newValue * 2;
    });

    return { x, result };
  },
};
</script>
