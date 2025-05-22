<template>
  <div id="cards" class="d-flex flex-wrap">
    <TodoItem
      v-for="(todo, index) in todos"
      :key="todo.id"
      :todo="todo"
      @removeTodo="$emit('delete-todo', todo.id)"
      @togglePriority="$emit('toggle-priority', todo)"
      @toggleTodo="$emit('toggle-todo', todo)"
    />
  </div>
</template>

<script>
import TodoItem from './TodoItem.vue';
export default {
  name: 'TodoList',
  components: {
    TodoItem,
  },
  props: ['todos'],
  emits: ['delete-todo', 'toggle-priority', 'toggle-todo'],
};
</script>

<style lang="scss" scoped></style>
