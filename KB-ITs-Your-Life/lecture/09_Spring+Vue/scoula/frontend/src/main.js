import './assets/main.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'vue-awesome-paginate/dist/style.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';
import { VueAwesomePaginate } from 'vue-awesome-paginate';

import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(VueAwesomePaginate); // 전역 컴포넌트 등록 -> 어디에서든 사용할 수 있다.
app.use(createPinia());
app.use(router);

app.mount('#app');
