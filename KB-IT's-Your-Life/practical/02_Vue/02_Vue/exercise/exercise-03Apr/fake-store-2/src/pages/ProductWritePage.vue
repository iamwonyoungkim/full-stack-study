<template>
  <form @submit.prevent="submit" class="mx-auto" style="width: 600px">
    <h2 class="my-5">상품 등록</h2>

    <div class="my-3">
      <label>카테고리: </label>
      <div class="form-control border-0">
        {{ product.category }}
      </div>
    </div>

    <div class="my-3">
      <label>상품명*: </label>
      <input type="text" class="form-control" v-model="product.title"></input>
    </div>

    <div class="my-3">
      <label>이미지 경로: </label>
      <input type="text" class="form-control" v-model="product.image"></input>
    </div>

    <div class="my-3">
      <label>설명: </label>
      <textarea class="form-control" v-model="product.description"></textarea>
    </div>

    <div class="text-center">
        <button class="btn btn-primary me-1" :disabled="isDisable">
            <i class="fa-solid fa-check"></i> 확인
        </button>

        <!-- 여기서 {name: category}는 무슨 뜻인가? -->
        <RouterLink :to="{name: category}" class="btn btn-primary">
            <i class="fa-solid fa-undo"></i> 취소
        </RouterLink>
    </div>
    
  </form>
</template>

<script setup>
import { computed, reactive } from 'vue';
import { RouterLink, useRoute, useRouter } from 'vue-router';
import * as api from '@/api/product.js';

const router = useRouter();
const currentRoute = useRoute();

// 왜 category를 객체로 쓰며, query는 무엇인가?
const { category } = currentRoute.query;

const product = reactive({
  category,
});

const isDisable = computed(() => !product.title || product.title.length < 5);

const submit = async () => {
  if (!confirm('등록할까요?')) return;

  const result = await api.post('/', product);

  console.log('등록 결과', result);
  router.push({ name: category });
};
</script>
