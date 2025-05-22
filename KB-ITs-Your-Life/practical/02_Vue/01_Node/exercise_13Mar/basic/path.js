const path = require('path');

// 경로 요소 결합
const fullPath = path.join('some', 'work', 'ex.txt');

// 현재 파일의 전체 절대 경로
console.log(fullPath);
console.log(`파일 절대 경로: ${__filename}`);

// 현재 파일의 디렉토리 경로
const dir = path.dirname(__filename);
console.log(`경로만1: ${dir}`);

// 현재 파일의 디렉토리 경로는 이 방법으로도 출력할 수 있다.
console.log(`경로만2: ${__dirname}`);

// 현재 파일의 파일명
const fn = path.basename(__filename); // 확장명 포함
const fn2 = path.basename(__filename, '.js'); // 선택한 확장명('.js') 제외
console.log(`파일 이름: ${fn}`);
console.log(`파일 이름(확장자 제외): ${fn2}`);

// 현재 파일의 확장명
const fe = path.extname(__filename);
console.log(`파일 확장자: ${fe}`);

// 현재 파일의 경로 요소 전체
const parsedPath = path.parse(__filename);
console.log(parsedPath);
