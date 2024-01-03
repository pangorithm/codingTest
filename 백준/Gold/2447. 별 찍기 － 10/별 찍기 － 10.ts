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

const num: number = parseInt(input[0][0]);

const recursiveFunction = (n: number) => {
  if (n == 3) {
    const innerBoard: string[][] = new Array();
    for (let i = 0; i < 3; i++) {
      innerBoard.push(new Array());
      for (let j = 0; j < 3; j++) {
        innerBoard[i][j] = '*';
      }
    }
    innerBoard[1][1] = ' ';
    return innerBoard;
  }

  const nextN = n / 3;
  const returnBoard: string[][] = new Array(n);
  for (let i = 0; i < n; i++) {
    returnBoard[i] = new Array();
  }

  for (let i = 0; i < n; i += nextN) {
    for (let j = 0; j < n; j += nextN) {
      const innerBoard: string[][] = recursiveFunction(nextN);
      if (i != nextN || j != nextN) {
        for (let ii = 0; ii < nextN; ii++) {
          for (let jj = 0; jj < nextN; jj++) {
            returnBoard[i + ii][j + jj] = innerBoard[ii][jj];
          }
        }
      } else {
        for (let ii = 0; ii < nextN; ii++) {
          for (let jj = 0; jj < nextN; jj++) {
            returnBoard[i + ii][j + jj] = ' ';
          }
        }
      }
    }
  }
  return returnBoard;
};

const board: string[][] = recursiveFunction(num);
let answer: string = '';
for (let i = 0; i < num; i++) {
  for (let j = 0; j < num; j++) {
    answer += board[i][j];
  }
  answer += '\n';
}

console.log(answer);
