function sumArray(numbers) {
  return numbers.reduce(function (sum, num) {
    return sum + num;
  }, 0);
}

const sumArray1 = (numbers) => numbers.reduce((sum, num) => sum + num, 0);

console.log(sumArray([1, 2, 3, 4, 5]));
console.log(sumArray1([1, 2, 3, 4, 5]));
