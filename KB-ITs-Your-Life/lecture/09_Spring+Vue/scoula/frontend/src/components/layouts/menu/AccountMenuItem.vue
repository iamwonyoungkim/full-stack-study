<script setup>
import { computed } from 'vue';
import { useAuthStore } from '@/stores/auth';

const props = defineProps({ username: String });
const auth = useAuthStore();

const avatar = computed(
  () => `/api/member/${props.username}/avatar/${auth.avatarRand}`
);
</script>

<template>
  <li class="nav-item">
    <router-link class="nav-link" to="/auth/profile">
      <img :src="avatar" class="avatar avatar-sm" />
      {{ username }}
    </router-link>
  </li>
</template>
