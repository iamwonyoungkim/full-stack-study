function processArray(arr) {
  return arr
    .filter(function (num) {
      return num > 0;
    })
    .map(function (num) {
      return num * 2;
    });
}

const processArray1 = (arr) => {
  return arr.filter((num) => num > 0).map((num) => num * 2);
};

console.log(processArray([-1, 2, 3]));
console.log(processArray1([-1, 2, 3]));
