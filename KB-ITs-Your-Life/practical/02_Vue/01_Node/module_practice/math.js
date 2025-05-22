// 앞에 export 붙이는 건 ES 모듈 시스템 방식.
export function add(a, b) {
  return a + b;
}

export function subtract(a, b) {
  return a - b;
}

// module.exports = { add, subtract }; -> CommonJS 모듈 시스템 방식.

export default function (a, b) {
  return a + b;
}

// 변수, 함수, 클래스, 배열, 객체 export 가능
