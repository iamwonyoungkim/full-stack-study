<script setup>
import * as api from '@/api/product.js';
import ProductList from '@/components/ProductList.vue';
import ProductAddButton from '@/components/ProductAddButton.vue';
import { reactive } from 'vue';

const category = "men's clothing";
const state = reactive({ products: [] });

const load = async () => {
  state.products = await api.get('/category/' + category);
  console.log(state.products);
};
load();
</script>
<template>
  <h1 class="mb-5"><i class="fa-solid fa-user-tie"></i> 남성 의류</h1>
  <ProductList :products="state.products" />
  <ProductAddButton :category="category" />
</template>
