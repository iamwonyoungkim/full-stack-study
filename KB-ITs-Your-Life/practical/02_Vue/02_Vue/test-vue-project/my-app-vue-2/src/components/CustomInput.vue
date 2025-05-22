<template>
  <!-- :value 뒤에는 양방향을 꿈꾸는 속성!을 넣어준다 -->
  <input
    type="text"
    :value="title"
    @input="$emit('update:title', $event.target.value)"
  />
</template>

<script>
export default {
  name: 'CustomInput',
  props: {
    title: String,
  },
};
</script>
