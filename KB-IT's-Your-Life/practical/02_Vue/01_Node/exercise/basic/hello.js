// const c = require('ansi-colors');

// function greet(name) {
//   console.log(`${c.green(name)} 님, 안녕하세요?`);
// }

// greet('홍길동');

const hello = (name) => {
  console.log(`${name} 님, 안녕하세요?`);
};

module.exports = { hello };
