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
        .readFileSync(__dirname + '/myTest.txt')
        .toString()
        .trim()
        .split('\n')
        .map((ln) => ln.trim().split(' '));

let answer: string = '';

const T: number = parseInt(input[0][0]);
for (let t = 1; t <= T; t++) {
  const x: number = parseInt(input[t][0]);
  const y: number = parseInt(input[t][1]);
  let move: number = 1;
  let leftDistance: number = y - x;
  let count: number = 0;
  while (leftDistance > 0) {
    if (leftDistance >= move * 2) {
      leftDistance -= move * 2;
      count += 2;
    } else {
      leftDistance -= move;
      count++;
    }

    move++;
  }

  answer += count + '\n';
}

console.log(answer);
