import { defineStore } from 'pinia';

export const useFavouritesStore = defineStore('favourites', {
  // state는 공유할 데이터이다.
  state: () => ({
    favourites: [],
  }),
  // actions는 해당 데이터를 다루는 함수들이다.
  actions: {
    addFavourite(book) {
      // prevent duplication
      if (!this.favourites.find((item) => item.id === book.id)) {
        this.favourites.push(book);
      }
    },
    removeFavourite(bookId) {
      this.favourites = this.favourites.filter((item) => item.id !== bookId);
    },
    // some은 JS의 배열 메서드로, '배열 안에 특정 조건을 만족하는 요소가 하나라도 있는가?'를 판단하는 함수이다.
    /*
    array.some(callback)의 형태
        - callback은 배열의 각 요소에 대해 실행되는 함수
        - true를 반환하는 요소가 하나라도 있으면 some()은 즉시 true를 반환
        - 전부 통과 못 하면 false 반환
    */
    isFavourite(bookId) {
      return this.favourites.some((item) => item.id === bookId);
    },
  },
});
