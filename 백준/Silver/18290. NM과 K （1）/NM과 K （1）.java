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
    board = new Cell[N + 2][M + 2];
    max = Integer.MIN_VALUE;

    int lastN = N + 1;
    int lastM = M + 1;
    for (int i = 0; i <= lastN; i++) {
      board[i][0] = new Cell();
      board[i][lastM] = new Cell();
    }
    for (int j = 0; j <= lastM; j++) {
      board[0][j] = new Cell();
      board[lastN][j] = new Cell();
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
        if (!set.contains(board[startI - 1][j]) && !set.contains(board[startI][j - 1])) {
          HashSet<Cell> nextSet = new HashSet<>(set);
          nextSet.add(board[startI][j]);
          dfs(nextSet, dept, startI, j);
        }
      }

      for (int i = startI + 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
          if (!set.contains(board[i - 1][j]) && !set.contains(board[i][j - 1])) {
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