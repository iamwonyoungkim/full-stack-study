<template>
  <div id="app" class="container">
    <nav class="navbar bg-body-tertiary">
      <div class="container-fluid">
        <span class="navbar-brand mb-0 h1"
          >ToDo - {{ remainingTodos }} / {{ todos.length }} 개 남음</span
        >
      </div>
    </nav>
    <main>
      <InputTodo @add-todo="addTodo" />
      <TodoList
        :todos="todos"
        @delete-todo="removeTodo"
        @toggle-priority="togglePriority"
        @toggle-todo="toggleTodo"
      />
    </main>
  </div>
</template>

<script>
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';

export default {
  name: 'App',
  components: { InputTodo, TodoList },
  data() {
    return {
      todos: [
        {
          id: 1,
          content: '자기',
          isDone: false,
          isPriority: true,
        },
        {
          id: 2,
          content: '놀기',
          isDone: true,
          isPriority: false,
        },
      ],
    };
  },
  computed: {
    remainingTodos() {
      return this.todos.filter((todo) => !todo.isDone).length;
    },
  },
  methods: {
    addTodo(todo) {
      console.log('addTodo 실행');
      console.log(this.todos);
      const uniqueId = Date.now() + Math.random().toString(36);

      this.todos.push({
        id: uniqueId,
        content: todo,
        isDone: false,
        removed: false,
      });

      console.log(this.todos);
    },

    removeTodo(id) {
      this.todos = this.todos.filter((todo) => todo.id !== id);
    },

    togglePriority(todo) {
      if (!todo.isDone) {
        todo.isPriority = !todo.isPriority;
      }
    },

    toggleTodo(todo) {
      todo.isDone = !todo.isDone;
      todo.isPriority = false;
    },
  },
};
</script>

<style lang="scss" scoped></style>
