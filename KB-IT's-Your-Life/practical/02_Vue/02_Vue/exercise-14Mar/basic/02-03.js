const p1 = { name: 'john', age: 20 };
p1.age = 22;
console.log(p1);

// p1 = { name: 'lee', age: 25 };

// 예상 output:
// 에러
// -> 에러 코드 주석 처리 후 예상 output:
// { name: 'john', age:22 }
