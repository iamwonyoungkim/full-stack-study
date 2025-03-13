const fs = require('fs');

// 비동기 처리로 디렉터리 읽기기
fs.readdir('./', (err, files) => {
  if (err) {
    console.error(err);
  }
  console.log(files);
});
