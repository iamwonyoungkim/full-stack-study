import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/pages/HomePage.vue';
import AboutPage from '@/pages/AboutPage.vue';
import ContactPage from '@/pages/ContactPage.vue';
import BookList from '@/pages/BookList.vue';
import BookDetail from '@/pages/BookDetail.vue';
import NotFound from '@/pages/NotFound.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomePage,
    // },
    // {
    //   path: '/about',
    //   name: 'about',
    //   component: AboutPage,
    // },
    // {
    //   path: '/contact',
    //   name: 'Contact',
    //   component: ContactPage,
    // },
    {
      path: '/books',
      name: 'BookList',
      component: BookList,
    },
    {
      path: '/books/:id',
      name: 'BookDetail',
      component: BookDetail,
      props: true,
    },
    {
      path: '/:paths(.*)*',
      name: 'NotFound',
      component: NotFound,
    },
  ],
});

export default router;
