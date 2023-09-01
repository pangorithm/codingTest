import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int K;
  static Cell[][] board;
  static int max;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    board = new Cell[N + 1][M + 1];
    max = Integer.MIN_VALUE;

    for (int i = 0; i <= N; i++) {
      board[i][0] = new Cell();
    }
    for (int j = 0; j <= M; j++) {
      board[0][j] = new Cell();
    }
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 1; j <= M; j++) {
        board[i][j] = new Cell(Integer.parseInt(st.nextToken()));
      }
    }

    dfs(new HashSet<Cell>(), 0, 1, -1);

    System.out.println(max);
    in.close();
  }

  static void dfs(HashSet<Cell> set, int dept, int startI, int startJ) {
    if (dept == K) {
      int sum = 0;
      for (Cell cell : set) {
        sum += cell.value;
      }
      if (max < sum) {
        max = sum;
      }
    } else {
      dept++;

      for (int j = startJ + 2; j <= M; j++) {
        if (!set.contains(board[startI - 1][j])) {
          HashSet<Cell> nextSet = new HashSet<>(set);
          nextSet.add(board[startI][j]);
          dfs(nextSet, dept, startI, j);
        }
      }

      int tempI = startI + 1;
      if (tempI <= N) {
        for (int j = 1; j <= M; j++) {
          if (!set.contains(board[tempI - 1][j])) {
            HashSet<Cell> nextSet = new HashSet<>(set);
            nextSet.add(board[tempI][j]);
            dfs(nextSet, dept, tempI, j);
          }
        }

        for (int i = startI + 2; i <= N; i++) {
          for (int j = 1; j <= M; j++) {
            HashSet<Cell> nextSet = new HashSet<>(set);
            nextSet.add(board[i][j]);
            dfs(nextSet, dept, i, j);
          }
        }
      }
    }
  }

  static class Cell {
    int value;

    Cell() {
    }

    Cell(int value) {
      this.value = value;
    }
  }
}
