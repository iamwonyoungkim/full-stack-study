<template></template>

<script setup>
import axios from 'axios';

const runTests = async () => {
  try {
    // 기본 get 테스트
    const getResponse = await axios.get('/api/books');
    console.log('도서 목록 :', getResponse.data);

    // 아이디=1인 도서 가져오기
    const getById = await axios.get('/api/books/1');
    console.log('1번 도서 내용 :', getById.data);

    // 가격으로 정렬해서 가져오기 (price: 오름차순, -price: 내림차순)
    const getSortedByPrice = await axios.get('/api/books?_sort=-price');
    console.log('가격 기준 정렬 목록 :', getSortedByPrice.data);

    // 페이지네이션 (id로 역정렬, 페이지=2, 목록 개수=3)
    const getPage = await axios.get('/api/books?_sort=-id&_page=2&_per_page=3');
    console.log('페이지네이션된 도서 목록 :', getPage.data);

    const newBook = {
      title: '새로운 도서',
      author: '새 작가',
      price: 30000,
    };

    // post 테스트 (새로운 거 추가할 때)
    const postRes = await axios.post('/api/books', newBook);

    // put 테스트 (수정할 때)
    const updateBook = {
      title: '수정된 책 이름',
      author: '수정된 저자',
      price: 3,
    };
    const putRes = await axios.put('/api/books/1', updateBook);

    // 삭제
    await axios.delete('/api/books/1');
    // 위의 메소드 모두
    // 따로 출력할 일이 없다면 굳이 const 변수명으로 받을 필요없이 그냥 await으로 사용해도 된다.
  } catch (error) {
    console.error('에러 발생', error.message);
  }
};

runTests();
</script>
