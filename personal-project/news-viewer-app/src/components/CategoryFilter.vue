<template>
  <div class="d-flex flex-wrap gap-2 justify-content-center mb-4">
    <button
      v-for="category in categories"
      :key="category"
      class="btn btn-outline-secondary btn-sm"
      @click="$emit('select', category)"
    >
      {{ category }}
    </button>
  </div>
</template>

<script setup>
defineProps(['categories']);
</script>
