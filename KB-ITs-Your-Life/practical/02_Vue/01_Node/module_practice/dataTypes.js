// 문자열
const greeting = '안녕하세요';

// 숫자
const PI = 3.14159;
const maxNumber = 100;

// 배열
const colors = ['red', 'green', 'blue'];
const numbers = [1, 2, 3, 4, 5];

// 객체
const user = {
  name: '홍길동',
  age: 25,
  isAdmin: false,
};

// 클래스
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  sayHello() {
    return `${this.name}님 안녕하세요!`;
  }
}

// 함수
function add(a, b) {
  return a + b;
}

const multiply = (x, y) => x * y;

// Set
const uniqueNumbers = new Set([1, 2, 3, 3, 4]);

// Map
const userRoles = new Map([
  ['admin', '관리자'],
  ['user', '일반사용자'],
]);
