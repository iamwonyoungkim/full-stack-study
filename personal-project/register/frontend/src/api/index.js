import axios from 'axios';

import { useAuthStore } from '@/stores/auth';
import router from '@/router';

// const { getToken, logout } = useAuthStore();
// -> 이 때는 아직 Vue가 생성되기 전(store가 생성되기 전)이므로 이렇게 사용할 수 없다.

// 설정 객체
const instance = axios.create({
  timeout: 1000,
});

// 요청 인터셉터
instance.interceptors.request.use(
  // 요청을 보낼 때 호출됨
  (config) => {
    // config.headers : 요청 헤더

    // JWT 추출
    const { getToken } = useAuthStore();
    const token = getToken();
    if (token) {
      // 토큰이 있는 경우
      config.headers['Authorization'] = `Bearer ${token}`;
      console.log(config.headers.Authorization);
    }
    return config;
  },
  (error) => {
    // 요청 중 에러가 난 경우
    return Promise.reject(error);
  }
);

// 응답 인터셉터
instance.interceptors.response.use(
  (response) => {
    // 정상 응답인 경우 (200, 404)
    if (response.status === 200) {
      return response;
    }
    if (response.status === 404) {
      return Promise.reject('404: 페이지 없음 ' + response.request);
    }
    return response;
  },
  async (error) => {
    // 에러 응답인 경우(401, 403, 305, 500 등)
    // ~?.xxx : Null 안정성 연산자. null이 아닌 경우에만 status를 읽음. Java의 Optional과 유사
    if (error.response?.status === 401) {
      const { logout } = useAuthStore();
      logout();
      router.push('/auth/login?error=login_required');
      return Promise.reject({ error: '로그인이 필요한 서비스입니다.' });
    }
    return Promise.reject(error);
  }
);

export default instance; // 인터셉터가 적용된 axios 인스턴스

/*
axios 인터셉터(interceptor)
- axios의 요청과 응답에 대한 필터 역할
    - 모든 요청을 가로채서 요청을 수정할 수 있음.
    - 모든 응답을 가로채서 응답을 수정할 수 있음.
- backend와의 모든 통신은 인증 토큰(jwt)를 포함해야 함
- Axios Interceptor 운영해야 함
    - 자동으로 모든 요청의 request 헤더에 인증 헤더 추가
    - Authentication: Bearer <토큰 문자열>
- 인터셉터가 설정된 axios 인스턴스를 작성하고, 백엔드 통신 시 이 인스턴스를 사용
*/
