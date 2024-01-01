import fs = require('fs');
var input: string[] = fs.existsSync('./src/myTest.txt')
  ? fs.readFileSync('./src/myTest.txt').toString().trim().split(' ')
  : fs.readFileSync('/dev/stdin').toString().trim().split(' ');
var a = parseInt(input[0]);
var b = parseInt(input[1]);
console.log(a + b);
