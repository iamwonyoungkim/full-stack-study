<template>
    <form @submit.prevent="submit" class="mx-auto" style="width: 600px">
      <h2 class="my-5">상품 수정</h2>
  
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
  
          <!-- params: {id : product.id} 이건 무슨 역할이며 어떻게 동작하는가? -->
          <RouterLink :to="{name: 'product/id', params: {id : product.id}}" class="btn btn-primary">
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
  const { category } = currentRoute.query;

  // currentRoute.params에는 어떤 내용이 들어있는가?
  const id = parseInt(currentRoute.params.id);
  
  const product = reactive({
    category,
  });
  
  const isDisable = computed(() => !product.title || product.title.length < 5);
  
  const submit = async () => {
    if (!confirm('수정할까요?')) return;
  
    const result = await api.put('/' + id, product);
  
    console.log('수정 결과', result);

    //name은 뭐고 params는 무엇이며 어떻게 사용되고 있는 것인가?
    router.push({ name: 'product/id', params: {id: product.id} });
  };
  
  // load의 역할은 무엇인가?
  const load = async () => {
    const data = await api.get('/' + id);
    
    // Object는 무엇인가?
    Object.assign(product, data);

    console.log(product);
  };
  load();
  </script>
  