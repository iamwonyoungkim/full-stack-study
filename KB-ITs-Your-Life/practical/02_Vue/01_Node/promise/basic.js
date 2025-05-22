// 문제 1: 기본 프로미스 생성
// 요구사항: 새로운 프로미스를 만들고, setTimeout을 사용하여 2초 후에
// "완료!" 메시지를 resolve하세요.
// then을 사용하여 결과를 출력하세요.
// 출력 결과: (2초 후) "완료!"

const test = new Promise((resolve, reject) => {
  setTimeout(() => resolve('완료!'), 2000);
});

test.then((result) => console.log(result));
