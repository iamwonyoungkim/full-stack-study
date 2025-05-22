<template>
  <div
    class="card m-2"
    style="width: 12rem"
    :class="cardClass(todo)"
    @click="$emit('togglePriority', todo.isPriority)"
  >
    <div class="card-body position-relative">
      <span
        v-if="todo.isPriority"
        class="position-absolute top-0 start-100 translate-middle p-2 bg-danger border border-light rounded-circle"
      >
      </span>
      <button
        class="position-absolute bottom-0 end-0 btn btn-close"
        @click.stop="$emit('removeTodo', todo.id)"
        style="margin: 0.5rem"
      ></button>
      <p class="card-text">{{ todo.content }}</p>
      <span
        class="badge"
        :class="spanClass(todo)"
        @click.stop="$emit('toggleTodo', todo.isDone)"
        >{{ todo.isDone ? '되돌리기' : '완료' }}</span
      >
    </div>
  </div>
</template>

<script>
export default {
  name: 'TodoItem',
  props: ['todo'],
  emits: ['removeTodo', 'togglePriority', 'toggleTodo'],
  computed: {
    cardClass() {
      return (todo) =>
        todo.isDone
          ? 'bg-secondary text-bg-secondary'
          : 'bg-warning text-bg-secondary';
    },
    spanClass() {
      return (todo) => (todo.isDone ? 'text-dark' : 'text-dark-emphasis');
    },
  },
};
</script>

<style lang="scss" scoped></style>
