import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import { createPinia } from 'pinia';

// Pinia 스토어 생성
const pinia = createPinia();

// Vue 애플리케이션 생성
const app = createApp(App);

app.use(router);
app.use(pinia);

// 앱 마운트
app.mount('#app');
