import { defineStore } from 'pinia';
import { ref, watch } from 'vue';

export const useFavouritesStore = defineStore('favourites', () => {
  const favourites = ref([]);

  // ✅ 앱이 시작할 때 로컬스토리지에서 데이터 불러오기
  const stored = localStorage.getItem('favourites'); // 가져오는 값은 항상 String이다.
  if (stored) {
    try {
      // JSON.parse()는 문자열로 된 JSON 데이터를 다시 JavaScript 객체로 변환하는 함수이다.
      favourites.value = JSON.parse(stored);
    } catch (e) {
      console.error('로컬스토리지 파싱 실패:', e);
    }
  }

  // ✅ 즐겨찾기 추가
  function addFavourite(book) {
    if (!isFavourite(book.id)) {
      favourites.value.push(book);
    }
  }

  // ✅ 즐겨찾기 제거
  function removeFavourite(bookId) {
    favourites.value = favourites.value.filter((book) => book.id !== bookId);
  }

  // ✅ 특정 도서가 즐겨찾기 상태인지 확인
  function isFavourite(bookId) {
    return favourites.value.some((book) => book.id === bookId);
  }

  // ✅ 자동 저장: favorites가 바뀔 때마다 localStorage에 저장
  // watch는 reactive 데이터가 변경될 때마다 특정 콜백 함수를 실행하게 만들어주는 감시자이다.
  // 여기서는 favourites가 변경되면
  watch(
    favourites,
    (newVal) => {
      // JSON.stringify()는 JavaScript 객체를 JSON 문자열로 변환하는 함수이다.
      // 여기서는 배열을 JSON 문자열로 변환하여 localStorage에 저장한다.
      // localStorage.setItem()은 로컬 스토리지에 데이터를 저장하는 메서드이다.
      localStorage.setItem('favourites', JSON.stringify(newVal));
    },
    { deep: true } // 객체나 배열 같은 중첩된 구조 내부까지도 감시하게 만드는 옵션이다.
  );

  return {
    favourites,
    addFavourite,
    removeFavourite,
    isFavourite,
  };
});
