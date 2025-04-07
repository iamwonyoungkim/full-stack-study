import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/books',
      name: 'BookList',
      // 요청됐을 때 로딩한다 (lazy load)
      component: () => import('../views/BookList.vue'),
    },
  ],
});

export default router;
