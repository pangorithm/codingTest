import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] board; // 0흰 1빨 2파
  static final int WHITE = 0;
  static final int RED = 1;
  static final int BLUE = 2;
  static ArrayDeque<Horse>[][] horseBoard;
  static final int RIGHT = 1;
  static final int LEFT = 2;
  static final int UP = 3;
  static final int DOWN = 4;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    board = new int[N][N]; // 0흰 1빨 2파
    horseBoard = new ArrayDeque[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        horseBoard[i][j] = new ArrayDeque<>();
      }
    }

    Horse[] horses = new Horse[K];
    for (int k = 0; k < K; k++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      int dir = Integer.parseInt(st.nextToken());

      horses[k] = new Horse(r, c, dir);
      horseBoard[r][c].offer(horses[k]);
    }

    int answer = -1;
    loop: for (int turn = 1; turn <= 1000; turn++) {
      for (Horse h : horses) {
        if (h.equals(horseBoard[h.r][h.c].peekFirst())) {
          int nr = h.r;
          int nc = h.c;
          switch (h.dir) {
            case RIGHT:
              nc++;
              break;
            case LEFT:
              nc--;
              break;
            case UP:
              nr--;
              break;
            case DOWN:
              nr++;
              break;
          }

          if (checkColor(nr, nc) == BLUE) {
            if (h.dir <= 2) {
              h.dir = 3 - h.dir;
            } else {
              h.dir = 7 - h.dir;
            }

            nr = h.r;
            nc = h.c;
            switch (h.dir) {
              case RIGHT:
                nc++;
                break;
              case LEFT:
                nc--;
                break;
              case UP:
                nr--;
                break;
              case DOWN:
                nr++;
                break;
            }
          }

          if (checkColor(nr, nc) != BLUE) {
            move(nr, nc, horseBoard[h.r][h.c]);
            if (horseBoard[nr][nc].size() >= 4) {
              answer = turn;
              break loop;
            }
          }

        }
      }
    }

    System.out.println(answer);
    br.close();
  }

  static void move(int r, int c, ArrayDeque<Horse> horseTower) {
    if (board[r][c] == WHITE) {
      while (!horseTower.isEmpty()) {
        Horse horse = horseTower.pollFirst();
        horse.r = r;
        horse.c = c;
        horseBoard[r][c].offer(horse);
      }
    } else { // RED
      while (!horseTower.isEmpty()) {
        Horse horse = horseTower.pollLast();
        horse.r = r;
        horse.c = c;
        horseBoard[r][c].offer(horse);
      }
    }
  }

  static int checkColor(int r, int c) {
    if (Math.min(r, c) < 0 || Math.max(r, c) >= N) {
      return 2;
    } else {
      return board[r][c];
    }
  }

  static class Horse {
    int r;
    int c;
    int dir; // 1우 2좌 3상 4하

    Horse(int r, int c, int dir) {
      this.r = r;
      this.c = c;
      this.dir = dir;
    }
  }
}