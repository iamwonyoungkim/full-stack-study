import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomePage.vue';
import authRoutes from './auth';
import boardRoutes from './board';
import travelRoutes from './travel';
import galleryRoutes from './gallery';
import timetableRoutes from './timetable';
import registerRoutes from './register';
import questionRoutes from './question';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    // ...은 펼침 연산자이다. 각각의 Routes들이 배열이기 때문에 이렇게 작성할 수 있다.
    // authRoutes, boardRoutes, travelRoutes, galleryRoutes의 모든 라우트를 펼쳐서 추가한다.
    ...authRoutes,
    ...boardRoutes,
    ...travelRoutes,
    ...galleryRoutes,
    ...timetableRoutes,
    ...registerRoutes,
    ...questionRoutes,
  ],
});

export default router;
