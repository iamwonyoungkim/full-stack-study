// 화살표 함수
// () => {}

const hi = function (name) {
  return `${name}님, 안녕하세요!`;
};

// 기본적인 화살표 함수 형태
const hi1 = (name) => {
  return `${name}님, 안녕하세요!`;
};

// 매개변수가 하나인 경우 소괄호 생략 가능능
// const hi1 = name => {
//     return `${name}님, 안녕하세요!`;
//   };

// 중괄호 안에 return 문 하나만 있는 경우, 중괄호 & return 생략 가능
const hi2 = (name) => `#{name}님, 안녕하세요!`;
