<template>
  <div class="container">
    <h1>📚 도서 검색</h1>
    <div class="input-group">
      <!-- 
        v-model은 input과 데이터(state)를 양방향으로 연결해주는 디렉티브이다.
        아래와 같이 적으면 searchQuery라는 ref 변수와 input 값이 자동으로 연결된다.
        즉, input에 글자를 입력하면 searchQuery.value 값이 바뀌고, searchQuery를 코드에서 바꾸면 input창에도 반영된다.
        (양방향 바인딩(two-way binding))
      -->
      <input
        v-model="searchQuery"
        type="text"
        class="form-control"
        placeholder="도서 제목을 입력하세요."
        @keyup.enter="fetchBooks"
      />
      <button class="btn btn-primary" @click="fetchBooks">검색</button>
    </div>

    <!-- 
      reactive 변수의 값이 변경되면, Vue가 자동으로 DOM을 다시 렌더링한다.
      즉, ref나 reactive로 선언한 값이 변하면 v-if, v-for, :class 등은 다 반응해서 자동으로 동작한다.
    -->
    <div v-if="books.length > 0">
      <BookItem v-for="book in books" :key="book.id" :book="book" />
    </div>

    <p v-else-if="searched">검색 결과가 없습니다.</p>
  </div>
</template>

<script setup>
// ref는 반응형 변수를 만들기 위한 Composition API 함수이다.
import { ref } from 'vue';
import axios from 'axios';
import BookItem from '@/components/BookItem.vue';

// 아래처럼 선언하면, searchQuery는 Vue가 추적할 수 있는 반응형 변수가 된다.
// 즉, 이 값을 바꾸면 자동으로 UI가 갱신된다.
// 주의할 점!
// - ref로 만든 변수는 .value로 접근해야 된다. e.g. searchQuery.value = 'javascript'
// - 하지만 <template> 안에서 사용할 땐 .value를 생략할 수 있다. e.g. {{ searchQuery }}
const searchQuery = ref('');
const books = ref([]);
const searched = ref(false);

const fetchBooks = async () => {
  // if searchQuery is empty, then return nothing
  if (!searchQuery.value.trim()) return;

  // 사용자가 입력한 키워드를 가지고 Google Books API에 axios로 요청 보낸다.
  // encodeURIComponent()는 URL에 포함될 수 없는 문자(공백, 한글 등)를 안전하게 변환해주는 함수이다.
  // e.g. encodeURIComponent('vue js')의 결과값: "vue%20js"
  try {
    const response = await axios.get(
      `https://www.googleapis.com/books/v1/volumes?q=${encodeURIComponent(
        searchQuery.value
      )}`
    );
    // A || B는 A가 false인 경우 B를 반환하고, 그렇지 않으면 A를 반환한다.
    books.value = response.data.items || [];
    searched.value = true;
  } catch (error) {
    console.error('도서 검색 중 오류 발생:', error);
  }
};
</script>
