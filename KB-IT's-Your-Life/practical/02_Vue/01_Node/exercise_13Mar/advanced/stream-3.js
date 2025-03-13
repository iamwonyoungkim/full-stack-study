// pipe

const fs = require('fs');

const readStream = fs.createReadStream('./readMe.txt', 'utf8');
const writeStream = fs.createWriteStream('./writeMe2.txt');

readStream.pipe(writeStream);
