import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/pages/HomePage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: '/electronics',
      name: 'electronics',
      component: () => import('../pages/ElectronicsPage.vue'),
    },
    {
      path: '/jewelry',
      name: 'jewelry',
      component: () => import('../pages/JewelryPage.vue'),
    },
    {
      path: '/menclothing',
      name: 'menclothing',
      component: () => import('../pages/MenClothingPage.vue'),
    },
    {
      path: '/womenclothing',
      name: 'womenclothing',
      component: () => import('../pages/WomenClothingPage.vue'),
    },
  ],
});

export default router;
