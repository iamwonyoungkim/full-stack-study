<template>
  <div class="card card-body">
    <h2>Member Info</h2>
    <div>
      경로 패턴: /members/:id<br />
      요청 경로: {{ currentRoute.fullPath }}<br />
      id값: {{ currentRoute.params }}
    </div>
  </div>
</template>
<script>
import { useRoute } from 'vue-router';
import members from '@/members.json';

export default {
  name: 'MemberInfo',
  setup() {
    const currentRoute = useRoute();
    const id = parseInt(currentRoute.params.id, 10);
    const member = members.find((m) => m.id === id);
    return { member, currentRoute };
  },
};
</script>
