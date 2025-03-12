// const { add, subtract } = require('./math.js'); -> CommonJS 모듈 시스템 방식.

// default를 받아올 때는 하나만 있으므로 중괄호가 필요없고 이름도 마음대로 정할 수 있다.
import xyz, { add, subtract } from './math.js'; // ES 모듈 시스템 방식
console.log(add(5, 3));
console.log(subtract(5, 3));
console.log(xyz(5, 3));
