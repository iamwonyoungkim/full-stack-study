// 문제 3: 프로미스 체이닝 실습
// 요구사항: 숫자를 매개변수로 받아서 프로미스를 반환하는 함수를 만드세요.
// 매개변수로 받은 숫자를 처리 없이 바로 resolve 하세요.
// then을 3번 연속으로 체이닝하여 다음 작업을 순서대로 수행하세요:
// 1. 입력받은 숫자를 2배로 만들기
// 2. 결과값에 10을 더하기
// 3. "최종 결과: (계산된 값)" 형식으로 출력하기
// 매개변수가 5일때
// 출력 결과: "최종 결과: 20"

const num = (num) => {
  return new Promise((resolve, reject) => {
    resolve(num);
  });
};

num(5)
  .then((result) => result * 2)
  .then((mul) => mul + 10)
  .then((final) => console.log(`최종 결과: ${final}`));
