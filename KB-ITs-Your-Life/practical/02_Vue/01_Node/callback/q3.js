function pass(score, callback) {
  //   if (60 <= score) {
  //     callback('합격');
  //   } else {
  //     callback('불합격');
  //   }

  const result = 60 <= score ? '합격' : '불합격';
  callback(result);
}

function print(result) {
  console.log(`${result}입니다.`);
}

pass(59, print);
