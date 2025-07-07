export default [
  {
    path: '/travel/list',
    name: 'travel/list',
    component: () => import('../pages/travel/TravelListPage.vue'), // Lazy-loaded component
  },
  {
    path: '/travel/detail/:no',
    name: 'travel/detail',
    component: () => import('../pages/travel/TravelDetailPage.vue'), // Lazy-loaded component
  },
];
