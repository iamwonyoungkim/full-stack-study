<template>
  <div class="my-3">
    <img
      :src="product.image"
      alt="product image"
      width="30"
      height="30"
      class="me-2"
    />
    <router-link :to="{ name: 'product/id', params: { id: product.id } }">{{
      product.title
    }}</router-link>
  </div>
</template>
<script setup>
import { RouterLink } from 'vue-router';

const props = defineProps({ product: { type: Object, required: true } });
console.log(props.product);
</script>
