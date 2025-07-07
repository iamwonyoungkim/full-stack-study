<script setup>
import { useRoute } from 'vue-router';
const cr = useRoute();

const props = defineProps({
  travel: { Type: Object, required: true },
});
</script>

<template>
  <!-- grid 폭에 맞춤 -->
  <div class="card" style="width: 100%">
    <router-link
      :to="{
        name: 'travel/detail',
        params: { no: travel.no },
        query: cr.query,
      }"
    >
      <img
        :src="travel.images[0].url"
        :alt="travel.title"
        class="card-img-top"
      />
    </router-link>

    <div class="card-body">
      <h5 class="card-title">
        <router-link
          :to="{
            name: 'travel/detail',
            params: { no: travel.no },
            query: cr.query,
          }"
          >{{ travel.title }}</router-link
        >
      </h5>
      <p class="card-text">{{ travel.description.substring(0, 250) }}</p>
    </div>
  </div>
</template>

<style>
.card-img-top {
  height: 200px;
  /* 꽉 채워라. 튀어나가는 부분은 자른다. */
  object-fit: cover;
}

.card-text {
  /* 넘치는 부분은 숨겨라 */
  overflow: hidden;
  /* ellipsis -> 말 줄임 */
  text-overflow: ellipsis;
  display: -webkit-box;
  /* 줄 수 */
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}

a {
  text-decoration: none;
}
</style>
