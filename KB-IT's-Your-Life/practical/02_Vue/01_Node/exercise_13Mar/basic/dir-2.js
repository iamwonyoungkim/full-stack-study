const { error } = require('console');
const fs = require('fs');

if (fs.existsSync('./test2/test3/test4')) {
  console.log('folder already exists');
} else {
  // recursive 를 true로 지정하면 존재하지 않던 상위 폴더까지 한꺼번에 만들 수 있다.
  fs.mkdir('./test2/test3/test4', { recursive: true }, (err) => {
    if (err) {
      console.log(err);
    } else {
      console.log('folder created');
    }
  });
}
