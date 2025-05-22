function rank(purchase, callback) {
  const result = 50000 <= purchase ? '우수회원' : '일반회원';
  callback(result);
}

function print(result) {
  console.log(`${result} 입니다.`);
}

rank(49999, print);
