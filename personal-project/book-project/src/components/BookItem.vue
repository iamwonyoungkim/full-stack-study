<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">{{ book.volumeInfo.title }}</h5>
      <p class="card-text">
        {{ book.volumeInfo.authors?.join(', ') || '저자 정보 없음' }}
      </p>
    </div>
  </div>
</template>
<script setup>
// props는 부모 컴포넌트가 자식 컴포넌트에 데이터를 전달하는 방법이다.
/*
    부모 컴포넌트(SearchPage.vue)에서 <BookItem :book="book" />
        - 여기서 book은 props 이름이자,
        - :book="book"은 book이라는 데이터를 자식에게 넘겨준다는 뜻이다.
        - :book은 자식 컴포넌트의 props 이름, "book"은 현재 부모 컴포넌트 내부의 변수(book)이다.
    자식 컴포넌트(BookItem.vue)에서는 defineProps({ book: Object }) 이렇게 받는다.
        - 이렇게 하면 book이라는 이름의 prop을 받을 수 있다.
*/
defineProps({
  book: Object,
});
</script>
<!--
<script>
export default {
    props: {
        book: Object
    }
}
</script>
와 동일한 역할을 한다. 
-->
