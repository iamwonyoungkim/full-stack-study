<template>
  <!-- :value 뒤에는 양방향을 꿈꾸는 속성!을 넣어준다 -->
  <input
    type="checkbox"
    :checked="checked"
    @change="$emit('update:checked', $event.target.checked)"
  />
</template>

<script>
export default {
  name: 'CustomInput2',
  props: {
    checked: Boolean,
  },
};
</script>
