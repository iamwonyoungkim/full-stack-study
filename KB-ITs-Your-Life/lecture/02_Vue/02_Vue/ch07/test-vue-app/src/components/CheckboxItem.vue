<template>
  <li><input type="checkbox" v-model="checked" /></li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  data() {
    return {
      checked: false,
    };
  },
};
</script>
