function greet(name, callback) {
  const message = `${name}님, 안녕하세요!`;
  callback(message);
}

function print(msg) {
  console.log(msg);
}

greet('원영', print);
