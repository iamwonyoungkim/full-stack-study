export default {
  title: '용호초등학교 과학실험', // 메인 타이틀
  subtitle: '수강신청 사이트입니다.', // 서브 타이틀
  menus: [
    // 메인 메뉴 구성 정보
    {
      title: '시간표',
      url: '/timetable/list',
      icon: 'fa-solid fa-calendar-days',
    },
    {
      title: '수강신청',
      url: '/register/list',
      icon: 'fa-solid fa-user-plus',
    },
    {
      title: '질문하기',
      url: '/question/list',
      icon: 'fa-solid fa-clipboard-question',
    },
  ],
  accountMenus: {
    // 인증 관련 메뉴 정보
    login: {
      url: '/auth/login',
      title: '로그인',
      icon: 'fa-solid fa-right-to-bracket',
    },
    join: {
      url: '/auth/join',
      title: '회원가입',
      icon: 'fa-solid fa-user-plus',
    },
  },
};
