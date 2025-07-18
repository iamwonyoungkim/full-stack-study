import './assets/main.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'vue-awesome-paginate/dist/style.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';
import { VueAwesomePaginate } from 'vue-awesome-paginate';

import App from './App.vue';
import router from './router';

import { useKakao } from 'vue3-kakao-maps/@utils';
const rest_api_key = 'dc986f6601bc4a3fafb78e9fcf6f719b'; // Javascript 키 값
useKakao(rest_api_key, ['services']); // 첫 번째 인자: 키, 두 번째 인자: 사용할 옵션 서비스
// <script id="kakao-map-api-script" src="//dapi.kakao.com/v2/maps/sdk.js?appKey=dc986f6601bc4a3fafb78e9fcf6f719b&amp;autoload=false&amp;libraries=services"></script>가 추가됨

const app = createApp(App);

app.use(VueAwesomePaginate); // 전역 컴포넌트 등록 -> 어디에서든 사용할 수 있다.
app.use(createPinia());
app.use(router);

app.mount('#app');
