<template>
  <div class="card h-100">
    <img
      :src="data.urlToImage || 'https://via.placeholder.com/300x180'"
      class="card-img-top"
      alt="News Image"
    />
    <div class="card-body d-flex flex-column">
      <h5 class="card-title">{{ data.title }}</h5>
      <p class="card-text text-truncate">
        {{ data.description || '내용 없음' }}
      </p>
      <div class="mt-auto">
        <a
          :href="data.url"
          target="_blank"
          class="btn btn-sm btn-outline-primary"
          >원문 보기</a
        >
      </div>
    </div>
  </div>
</template>

<script setup>
defineProps(['data']);
</script>
