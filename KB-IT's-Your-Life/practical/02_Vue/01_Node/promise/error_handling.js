// 문제 2: 프로미스와 에러 처리
// 요구사항: 숫자를 매개변수로 받아서 새로운 프로미스를 반환하는 함수를 만드세요.
// 양수인 경우 resolve로 "(숫자)는 양수입니다" 메시지를 반환하고,
// 음수인 경우 reject로 "(숫자)는 음수입니다" 메시지를 반환하세요.
// then과 catch를 사용하여 결과를 처리하세요.
// 매개변수가 5일때
// 출력 결과: "5는 양수입니다"

const checkNum = (num) => {
  return new Promise((resolve, reject) => {
    if (0 <= num) {
      resolve(`${num}는 양수입니다`);
    } else {
      reject(`${num}는 음수입니다`);
    }
  });
};

checkNum(-5)
  .then((result) => console.log(result))
  .catch((err) => console.log(err));
