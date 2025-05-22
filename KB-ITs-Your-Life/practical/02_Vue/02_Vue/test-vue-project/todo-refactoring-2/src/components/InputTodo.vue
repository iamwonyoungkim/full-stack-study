<template>
  <div class="input-group center">
    <input
      type="text"
      class="form-control form-control-lg"
      v-model="todo"
      ref="todoInput"
      @keyup.enter="addTodoHandler"
      placeholder="할 일을 입력하세요"
    />
    <button
      class="btn btn-outline-secondary"
      type="button"
      id="button-addon2"
      @click="addTodoHandler"
    >
      추가
    </button>
  </div>
</template>

<!-- <script>
export default {
  name: 'InputTodo',
  data() {
    return {
      todo: '',
    };
  },
  methods: {
    addTodoHandler() {
      console.log('addTodoHandler 실행');
      if (this.todo.length >= 3 && this.todo.trim()) {
        this.$emit('add-todo', this.todo);
        // 입력값 초기화
        this.todo = '';
        // 입력 필드에 포커스
        this.$nextTick(() => {
          this.$refs.todoInput.focus();
        });
      }
    },
  },
};
</script> -->

<script setup>
import { ref, nextTick } from 'vue';

const todo = ref('');

const emit = defineEmits(['add-todo']);

function addTodoHandler() {
  console.log('addTodoHandler 실행');
  if (todo.value.length >= 3 && todo.value.trim()) {
    emit('add-todo', todo.value);
    // 입력값 초기화
    todo.value = '';
    // 입력 필드에 포커스
    nextTick(() => {
      ref.todoInput.focus();
    });
  }
}
</script>
