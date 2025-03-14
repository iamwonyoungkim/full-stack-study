const student = {
  name: '김지수',
  grade: 3,
  scores: {
    math: 95,
    english: 88,
    science: 92,
  },
};

const { name, grade } = student;
console.log(`${name} ${grade}학년`);
const {
  scores: { math, english },
} = student;
console.log(`수학 ${math}점, 영어 ${english}점`);

// 요구사항:
// 1. 학생의 이름과 학년을 구조 분해 할당으로 추출하세요
// 2. scores 객체에서 수학과 영어 점수만 추출하세요
// 3. 추출한 정보를 콘솔에 출력하세요

// 여기에 코드를 작성하세요
// const { name, grade } = student;
// const {
//   scores: { math, english },
// } = student;
// console.log(`${name} ${grade}학년`);
// console.log(`수학: ${math}, 영어: ${english}`);
