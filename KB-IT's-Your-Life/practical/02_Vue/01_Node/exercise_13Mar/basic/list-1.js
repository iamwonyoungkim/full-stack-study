const fs = require('fs');

// 동기 처리로 디렉터리 읽기
let files = fs.readdirSync('./'); // 디렉터리는 './'로 지정했으므로 현재 디렉터리가 된다.
console.log(files);
