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

const N: number = parseInt(input[0][0]);
let M: number = parseInt(input[0][1]);

const board: number[][] = new Array();

let houseList: number[][] = new Array();
let chickenList: number[][] = new Array();

let line: number = 1;
for (let i = 0; i < N; i++) {
  board[i] = new Array(N);

  for (let j = 0; j < N; j++) {
    board[i][j] = parseInt(input[line][j]);

    switch (board[i][j]) {
      case 1:
        houseList.push([i, j]);
        break;
      case 2:
        chickenList.push([i, j]);
        break;
    }
  }
  line++;
}

const selected: boolean[] = new Array(chickenList.length);
selected.fill(false);

if (M > chickenList.length) {
  M = chickenList.length;
}

const moves: number[][] = [
  [0, 1],
  [1, 0],
  [0, -1],
  [-1, 0],
];

let answer: number = 10000;

const selectChicken = (count: number, dept: number) => {
  if (count == M) {
    const distance: number[][] = new Array();
    for (let i = 0; i < N; i++) {
      distance[i] = new Array(N);
      distance[i].fill(100);
    }
    const queue: number[][] = new Array();
    let index: number = 0;
    for (let i: number = 0; i < chickenList.length; i++) {
      if (selected[i]) {
        const chicken: number[] = chickenList[i];
        chicken[2] = 0;
        queue.push(chicken);
        distance[chicken[0]][chicken[1]] = 0;
      }
    }

    while (index < queue.length) {
      const state: number[] = queue[index++];
      state[2]++;

      for (const m of moves) {
        const ny = state[0] + m[0];
        const nx = state[1] + m[1];
        if (ny >= 0 && ny < N && nx >= 0 && nx < N && distance[ny][nx] > state[2]) {
          distance[ny][nx] = state[2];
          queue.push([ny, nx, state[2]]);
        }
      }
    }

    let distanceSum: number = 0;
    for (const house of houseList) {
      distanceSum += distance[house[0]][house[1]];
    }
    if (answer > distanceSum) {
      answer = distanceSum;
    }
  } else {
    count++;
    for (let i: number = dept; i < selected.length; i++) {
      if (count <= M) {
        selected[i] = true;
        selectChicken(count, i + 1);
        selected[i] = false;
      }
    }
  }
};

selectChicken(0, 0);

console.log(answer);
