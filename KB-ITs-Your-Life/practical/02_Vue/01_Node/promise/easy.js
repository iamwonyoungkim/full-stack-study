// 사용자 데이터 조회
// userId를 받아서 사용자 정보를 가져오는 프로미스를 만드세요.
// 사용자정보
const users = {
  1: { id: 1, name: '김철수', email: 'kim@test.com' },
  2: { id: 2, name: '이영희', email: 'lee@test.com' },
  3: { id: 3, name: '주옥이', email: 'ju@test.com' },
};

const getUsers = (userId) => {
  return new Promise((resolve, reject) => {
    const user = users[userId];

    if (user) {
      resolve(user);
    } else {
      reject(`사용자 ID가 ${userId}인 사용자를 찾을 수 없습니다.`);
    }
  });
};

getUsers(1)
  .then((result) => console.log(result))
  .catch((err) => console.log(err));

// 게시글 조회
// userId를 받아서 해당 사용자의 게시글을 가져오는 프로미스를 만드세요.
const posts = {
  1: [
    { id: 10, title: '첫 번째 글' },
    { id: 22, title: '두 번째 글' },
  ],
  2: [{ id: 31, title: '안녕하세요' }],
};

const getPosts = (userId) => {
  return new Promise((resolve, reject) => {
    const user = posts[userId];
    if (user) {
      resolve(user);
    } else {
      reject(`사용자 ID가 ${userId}인 사용자를 찾을 수 없습니다.`);
    }
  });
};

getPosts(1)
  .then((result) => console.log(result))
  .catch((err) => console.log(err));

// 3.실행 예시:
//userId가가 1번인 경우 출력
//사용자 정보: { id: 1, name: '김철수', email: 'kim@test.com' }
//사용자의 게시글: [ { id: 10, title: '10 번째 글' }, { id: 22, title: '22 번째 글' } ]

//userId가 2번인 경우 출력
// 사용자 정보: { id: 2, name: '이영희', email: 'lee@test.com' }
// 사용자의 게시글: [ { id: 31, title: '안녕하세요' } ]

//userId가 3번인 경우
//사용자 정보: { id: 3, name: '주옥이', email: 'ju@test.com' }
//에러 발생: 게시글을 찾을 수 없습니다.

//userId가 4번인 경우
//에러 발생: 사용자를 찾을 수 없습니다.
