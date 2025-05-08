import { createRouter, createWebHistory } from 'vue-router';
import '@/pages/FavouritesPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView,
    // },
    // {
    //   path: '/favourites',
    //   name: 'favourites',
    //   component: () => import('../pages/FavouritesPage.vue'),
    // },
  ],
});

export default router;
