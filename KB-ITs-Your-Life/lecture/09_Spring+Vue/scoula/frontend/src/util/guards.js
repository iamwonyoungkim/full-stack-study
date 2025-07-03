import { useAuthStore } from '@/stores/auth';

// 여기(top-level)는 아직 store가 만들어지기 전이므로 useAuthStore()를 호출할 수 없다.

export const isAuthenticated = (to, from) => {
  // from: 어디에서 왔느냐. 가끔 필요할 때가 있다.
  const auth = useAuthStore();

  if (!auth.isLogin) {
    // 로그인 되어 있지 않은 경우
    console.log('로그인 필요.....');
    return { name: 'login', query: { next: to.name } }; // query: { next: to.name } -> ?next=xxx
  }
  console.log('로그인 인증');
};
