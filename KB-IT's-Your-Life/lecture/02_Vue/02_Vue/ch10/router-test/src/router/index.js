import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/pages/HomePage.vue';
import AboutPage from '@/pages/AboutPage.vue';
import MembersPage from '@/pages/MembersPage.vue';
import VideosPage from '@/pages/VideosPage.vue';
import MemberInfoPage from '@/pages/MemberInfoPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: '/about',
      name: 'about',
      component: AboutPage,
    },
    {
      path: '/members',
      name: 'members',
      component: MembersPage,
    },
    { path: '/members/:id', component: MemberInfoPage },
    {
      path: '/videos',
      name: 'videos',
      component: VideosPage,
    },
  ],
});

export default router;
