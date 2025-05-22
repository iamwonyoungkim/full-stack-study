function add(num1, num2, callback) {
  const sum = num1 + num2;
  callback(sum);
}

function print(sum) {
  console.log(sum);
}

add(1, 30, print);
