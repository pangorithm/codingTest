import fs = require('fs');
const input: string[][] =
  process.platform === 'linux'
    ? fs
        .readFileSync('/dev/stdin')
        .toString()
        .trim()
        .split('\n')
        .map((ln) => ln.trim().split(' '))
    : fs
        .readFileSync('./src/myTest.txt')
        .toString()
        .trim()
        .split('\n')
        .map((ln) => ln.trim().split(' '));

var a = parseInt(input[0][0]);
var b = parseInt(input[0][1]);

console.log(a + b);
