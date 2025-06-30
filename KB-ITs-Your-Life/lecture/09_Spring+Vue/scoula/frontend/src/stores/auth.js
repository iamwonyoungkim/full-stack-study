// 새로 고침을 하면 스토어가 리셋됨
// - 상태가 변경될 때(로그인, 로그아웃)마다 localStorage에 저장
// - 첫 기동할 때 localStorage에서 상태 복원

import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

// AuthResultDTO의 모양
const initState = {
  token: '', // 접근 토큰(JWT)
  user: {
    // 로그인 사용자 정보
    username: '', // 사용자 ID
    email: '', // Email
    roles: [], // 권한 목록
  },
};

export const useAuthStore = defineStore('auth', () => {
  const state = ref({ ...initState }); // 객체 복사
  // 객체인데 ref를 사용하는 이유?
  // 부분만 바꿀 때는 reactive를 사용하고, 전체를 바꿀 때는 ref를 사용하는 것이 좋다.

  // ReadOnly로 운영. -> Pinia 바깥에서는 수정할 수 없도록
  const isLogin = computed(() => !!state.value.user.username); // 로그인 여부

  const username = computed(() => state.value.user.username); // 로그인 사용자 ID

  const email = computed(() => state.value.user.email); // 로그인 사용자 Email

  const login = async (member) => {
    // state.value.token = 'test token'; // 실제로는 서버에서 토큰을 받아와야 함
    // state.value.user = {
    //   username: member.username,
    //   email: member.username + '@test.com',
    // };

    // api 호출
    const { data } = await axios.post('/api/auth/login', member); // data는 서버(LoginSuccessHandler)에서 응답한 AuthResultDTO 객체
    state.value = { ...data }; // 서버에서 받은 데이터로 상태 업데이트
    localStorage.setItem('auth', JSON.stringify(state.value)); // 상태를 localStorage에 저장
  };

  const logout = () => {
    localStorage.clear();
    state.value = { ...initState }; // 상태 초기화
  };

  const getToken = () => state.value.token; // 토큰 반환

  const load = () => {
    const auth = localStorage.getItem('auth');
    if (auth != null) {
      state.value = JSON.parse(auth); // 이 작업 때문에 reactive를 사용하지 않고 ref를 사용
      console.log(state.value);
    }
  };

  load(); // 기동 시

  // 무엇을 리턴할 거냐가 중요!!
  return { state, username, email, isLogin, login, logout, getToken };
  /*
  - state: 상태 객체 // 비권장(다른 곳에서 수정할 수 있기 때문에)
  - 나머지: 권장
    - username, email, isLogin: 읽기 전용 속성
    - login, logout, getToken: 메서드 (이 메서드들을 통해서 수정할 수 있음)
  */
});
