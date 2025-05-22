const fs = require('fs');

fs.readFile('./example.txt', 'utf8', (err, data) => {
  if (err) {
    console.log(err);
  } else {
    fs.writeFile('./text-2.txt', data, (err) => {
      if (err) {
        console.log(err);
      } else {
        console.log('text-2.txt is saved!');
      }
    });
  }
});
