<script setup>
import { useTodoListStore } from '@/stores/todoList.js';
import { computed } from 'vue';

const store = useTodoListStore();
const { todoList, addTodo, deleteTodo, toggleDone } = store;
const doneCount = computed(() => store.doneCount);
</script>

<template>
  <h1 style="margin-bottom: 10px">TodoList 테스트(Composition API)</h1>
  <hr />
  <form action="">
    <label for="">할 일 추가 : <input type="text" /></label>
    <button>추가</button>
  </form>
  <hr />
  <ul v-for="todoItem in todoList">
    <li>
      <span @click="toggleDone(todoItem.id)">{{ todoItem.todo }}</span>

      <span v-if="todoItem.done === true"> (완료)</span>
      <span><button @click="deleteTodo(todoItem.id)">삭제</button></span>
    </li>
  </ul>
  <p>완료된 할 일 수 : {{ doneCount }}</p>
</template>

<style scoped>
form {
  margin: 10px 0;
}
</style>
