import { createRouter, createWebHistory } from 'vue-router';
import SearchPage from '@/pages/SearchPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'search',
      component: SearchPage,
    },
    // {
    //   path: '/favourites',
    //   name: 'favourites',
    //   component: () => import('../pages/FavouritesPage.vue'),
    // },
  ],
});

export default router;
