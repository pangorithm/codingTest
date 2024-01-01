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

console.log(input);
