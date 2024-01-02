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

const hanoi = (plateCount: number, from: number, to: number, moves: number[][]): void => {
  if (plateCount == 1) {
    moves.push([from, to]);
    return;
  }

  const empty: number = 6 - (from + to);
  hanoi(plateCount - 1, from, empty, moves);
  hanoi(1, from, to, moves);
  hanoi(plateCount - 1, empty, to, moves);
};

const moves: number[][] = new Array();

hanoi(parseInt(input[0][0]), 1, 3, moves);

console.log(moves.length);

let answer: string = '';
for (let i = 0; i < moves.length; i++) {
  answer = answer + (moves[i][0] + ' ' + moves[i][1] + '\n');
}
console.log(answer);
