let p = new Promise((resolve, reject) => {
  console.log('first!');
  resolve();
});

p.then((msg) => {
  msg = 'second';
  console.log(msg);
})
  .then((msg) => {
    msg = 'third';
    console.log(msg);
  })
  .catch((error) => {
    console.log('오류 발생 ==>  ' + error);
  });
