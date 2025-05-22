import { defineStore } from 'pinia';
import { computed, ref } from 'vue';
import axios from 'axios';

export const useBookStore = defineStore('book', () => {
  // state
  const books = ref([]);
  const isLoading = ref(false);
  const error = ref(null);

  // getter
  const getBooks = computed(() => books);
  const getIsLoading = computed(() => isLoading.value);
  const getError = computed(() => error.value);

  // action
  const fetchBooks = async (sortBy) => {
    isLoading.value = true;
    try {
      const params = {
        // 역정렬
        _sort: `-${sortBy}`,
        _page: 1,
        _per_page: 3,
      };
      const response = await axios.get('/api/books', { params });
      // _per_page를 사용할 시 아래처럼 data.data로 받아와줘야 한다.
      // 이유는 get으로 받아와보면 확인할 수 있다.
      books.value = response.data.data;
    } catch (err) {
      // e.g. 네트워크 끊겼을 때
      error.value = '도서 목록 가져오기 실패하였습니다.';
    } finally {
      isLoading.value = false;
    }
  };
  return { getBooks, getIsLoading, getError, fetchBooks };
});
