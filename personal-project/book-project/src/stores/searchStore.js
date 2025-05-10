import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useSearchStore = defineStore('search', () => {
  const keyword = ref('');
  const results = ref([]);

  function setKeyword(value) {
    keyword.value = value;
  }

  function setResults(data) {
    results.value = data;
  }

  return {
    keyword,
    results,
    setKeyword,
    setResults,
  };
});
