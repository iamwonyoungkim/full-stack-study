<script setup>
import { useRouter } from 'vue-router';
import { useAuthStore } from '@/stores/auth';

const store = useAuthStore();

const router = useRouter();
const logout = (e) => {
  // 로그아웃
  store.logout();
  router.push('/');
};
</script>

<template>
  <!-- 
    @click.prevent : bubbling을 막는다. / default 이벤트를 막는다.
    @click.stop : capturing을 막는다.
    - bubbling: 이벤트가 하위 요소에서 상위 요소로 전파되는 것
    - capturing: 이벤트가 상위 요소에서 하위 요소로 전파되는 것
    -->
  <a href="#" class="nav-link" @click.prevent="logout">
    <i class="fa-solid fa-right-from-bracket"></i>
    로그아웃
  </a>
</template>
