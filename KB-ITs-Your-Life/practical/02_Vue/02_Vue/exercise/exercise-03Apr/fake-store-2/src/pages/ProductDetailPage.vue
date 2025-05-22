<script setup>
import * as api from '@/api/product.js';
import { useRoute, useRouter } from 'vue-router';
import { ref } from 'vue';

const router = useRouter();
const currentRoute = useRoute();
const id = parseInt(currentRoute.params.id);
const product = ref({});

console.log(id);

const remove = async () => {
  if (!confirm('삭제할까요?')) return;
  await api.remove('/' + id);
  router.push({ name: product.value.category });
};

const load = async () => {
  product.value = await api.get('/' + id);
  console.log(product.value);
};
load();
</script>

<template>
  <h1>{{ product.title }}</h1>
  <div>{{ product.category }}</div>
  <div class="text-end">
    가격: ${{ product.price }} /
    <i class="fa-solid fa-heart" style="color: red"></i> 평점:
    {{ product.rating.rate }} ({{ product.rating.count }}명)
  </div>
  <div>
    <img :src="product.image" alt="product image" width="100px" />
  </div>
  <div>{{ product.description }}</div>

  <div class="text-center my-5">
    <RouterLink :to="{ name: product.category }" class="btn btn-primary me-1">
      <i class="fa-solid fa-list"></i> 목록
    </RouterLink>
    <RouterLink
      :to="{ name: 'product/edit', params: { id: product.id } }"
      class="btn btn-primary me-1"
    >
      <i class="fa-solid fa-pen-to-square"></i> 수정
    </RouterLink>
    <button class="btn btn-danger me-1" @click="remove">
      <i class="fa-regular fa-trash-can"></i> 삭제
    </button>
  </div>
</template>
