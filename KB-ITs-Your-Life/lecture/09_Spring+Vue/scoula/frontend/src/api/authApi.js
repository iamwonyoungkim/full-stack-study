import api from 'axios';

const BASE_URL = '/api/member';
const headers = { 'Content-Type': 'multipart/form-data' };

export default {
  // username 중복 체크, true: 중복(사용불가), false: 사용가능
  async checkUsername(username) {
    const { data } = await api.get(`${BASE_URL}/checkusername/${username}`);
    console.log('AUTH GET CHECKUSERNAME', data);
    return data;
  },

  async create(member) {
    // 아바타 파일 업로드 - multipart 인코딩 필요 -> FormData 객체(html의 form을 캡슐화한 객체) 사용

    const formData = new FormData();
    formData.append('username', member.username); // 첫 번째 매개변수가 name, 두 번째 매개변수가 value
    formData.append('email', member.email);
    formData.append('password', member.password);

    if (member.avatar) {
      formData.append('avatar', member.avatar);
    }

    const { data } = await api.post(`${BASE_URL}`, formData, headers);

    console.log('AUTH POST: ', data);
    return data;
  },
};

/*
비동기 처리 방법
- callback: 함수 인자로 전달하여 처리
- promise: then() 메서드로 처리
- async/await: 비동기 함수로 처리
    - async는 함수 선언에, await는 promise를 return하는 비동기 함수 호출 시 사용
- axios: promise 기반의 HTTP 클라이언트 라이브러리
*/
