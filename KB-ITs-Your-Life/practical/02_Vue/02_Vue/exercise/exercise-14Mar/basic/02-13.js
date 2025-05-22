let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }
  inner();
};
obj.add(3, 4);

console.log(obj);
console.log(result);

// 예상 output:
// { result: 0 }
// 7

// 실제 output:
// { result: 0, add: [Function (anonymous)] }
// 7
