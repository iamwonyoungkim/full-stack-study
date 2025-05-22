function fruit(arr, callback) {
  arr.sort();
  callback(arr);
}

function print(arr) {
  console.log(arr);
}

fruit(['사과', '키위', '바나나'], print);
