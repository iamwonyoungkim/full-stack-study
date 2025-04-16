<template>
  <div class="input-group mb-3">
    <input
      type="text"
      class="form-control"
      placeholder="검색어 입력..."
      v-model="keyword"
      @keyup.enter="$emit('search', keyword)"
    />
    <button class="btn btn-primary" @click="$emit('search', keyword)">
      <i class="fas fa-search"></i>
    </button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
const keyword = ref('');
</script>
