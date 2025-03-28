<template>
  <div class="input-group center">
    <input
      type="text"
      class="form-control form-control-lg"
      v-model="todo"
      ref="todoInput"
      @keyup.enter="addTodooHandler"
      placeholder="할 일을 입력하세요"
    />
    <button
      class="btn btn-outline-secondary"
      type="button"
      id="button-addon2"
      @click="addTodooHandler"
    >
      추가
    </button>
  </div>
</template>

<script>
export default {
  name: 'InputTodo',
  data() {
    return {
      todo: '',
    };
  },
  methods: {
    addTodooHandler() {
      console.log('addTodooHandler 실행');
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
</script>
