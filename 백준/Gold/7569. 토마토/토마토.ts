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

const M = parseInt(input[0][0]);
const N = parseInt(input[0][1]);
const H = parseInt(input[0][2]);

const tomatoBox: number[][][] = new Array(H);
let count: number = 0; // 안익은 토마토 수

let queue: number[][] = new Array();
let line = 1;
for (let h = 0; h < H; h++) {
  tomatoBox[h] = new Array(N);
  for (let n = 0; n < N; n++) {
    tomatoBox[h][n] = new Array(M);
    for (let m = 0; m < M; m++) {
      tomatoBox[h][n][m] = parseInt(input[line][m]);
      if (tomatoBox[h][n][m] == 0) {
        count++;
      } else if (tomatoBox[h][n][m] == 1) {
        queue.push([h, n, m]);
      }
    }
    line++;
  }
}

const moves: number[][] = [
  [0, 0, 1],
  [0, 0, -1],
  [0, 1, 0],
  [0, -1, 0],
  [1, 0, 0],
  [-1, 0, 0],
];

let queueIndex: number = 0;
let day: number = 0;
while (count > 0) {
  day++;
  const nextQueue: number[][] = new Array();
  while (queue.length > queueIndex) {
    const tomato: number[] = queue[queueIndex++];

    for (const m of moves) {
      const nh = tomato[0] + m[0];
      const nn = tomato[1] + m[1];
      const nm = tomato[2] + m[2];
      if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M && tomatoBox[nh][nn][nm] == 0) {
        tomatoBox[nh][nn][nm] = 1;
        nextQueue.push([nh, nn, nm]);
        count--;
      }
    }
  }
  queue = nextQueue;
  queueIndex = 0;
  if (queue.length == 0) {
    break;
  }
}

console.log(count == 0 ? day : -1);
