// 콜백 함수

function greet(name, callback) {
  const message = `${name}님 안녕하세요!`;
  callback(message); // message를 콜백함수에 전달달
}

function displayGreeting(msg) {
  console.log(msg);
}

greet('철수', displayGreeting); // 출력: 철수님 안녕하세요!
