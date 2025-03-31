<template>
  <div class="card card-body">
    <h2>About</h2>
    <!-- Options API -->
    <!-- <p>요청 경로 : {{ $route.fullPath }}</p> -->

    <!-- Composition API -->
    <p>요청 경로 : {{ currentRoute.fullPath }}</p>
  </div>
</template>

<!-- Options API -->
<!-- <script>
export default {
  name: 'About',
  created() {
    console.log(this.$route);
  },
};
</script> -->

<!-- Composition API -->
<!-- <script>
import { useRoute } from 'vue-router';

export default {
  name: 'About',
  setup() {
    const currentRoute = useRoute();
    console.log(currentRoute.fullPath);
    return { currentRoute };
  },
};
</script> -->

<script setup>
import { useRoute } from 'vue-router';

const currentRoute = useRoute();
console.log(currentRoute);
</script>
