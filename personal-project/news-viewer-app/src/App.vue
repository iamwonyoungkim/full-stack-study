<template>
  <div class="container py-4">
    <h1 class="mb-4 text-center">📰 뉴스 요약 뷰어</h1>
    <SearchBar @search="handleSearch" />
    <CategoryFilter :categories="categories" @select="handleCategorySelect" />

    <div v-if="isLoading" class="text-center py-5">
      <div class="spinner-border" role="status">
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>

    <div class="row mt-4" v-else>
      <NewsCard
        v-for="(article, idx) in newsList"
        :key="idx"
        :data="article"
        class="col-md-4 mb-4"
      />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import SearchBar from './components/SearchBar.vue';
import CategoryFilter from './components/CategoryFilter.vue';
import NewsCard from './components/NewsCard.vue';

const newsList = ref([]);
const isLoading = ref(false);
const selectedCategory = ref('general');
const searchKeyword = ref('');

const categories = [
  'general',
  'business',
  'entertainment',
  'health',
  'science',
  'sports',
  'technology',
];

const API_KEY = import.meta.env.VITE_NEWS_API_KEY;
const fetchNews = async () => {
  isLoading.value = true;
  try {
    const response = await axios.get('https://newsapi.org/v2/top-headlines', {
      params: {
        country: 'us',
        category: selectedCategory.value,
        q: searchKeyword.value || undefined,
        apiKey: API_KEY,
      },
    });
    newsList.value = response.data.articles;
  } catch (error) {
    console.error('뉴스 불러오기 실패:', error);
  } finally {
    isLoading.value = false;
  }
};

onMounted(fetchNews);

const handleSearch = (keyword) => {
  searchKeyword.value = keyword;
  fetchNews();
};

const handleCategorySelect = (category) => {
  selectedCategory.value = category;
  fetchNews();
};
</script>
