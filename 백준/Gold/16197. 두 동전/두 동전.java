import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static char[][] board;
  static int[][] coins;
  static int min;
  static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    min = Integer.MAX_VALUE;

    coins = new int[2][2];
    int index = 0;
    for (int i = 0; i < N; i++) {
      board[i] = in.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        if (board[i][j] == 'o') {
          coins[index][0] = i;
          coins[index][1] = j;
          index++;
          board[i][j] = '.';
        }
      }
    }
    dfs(0);

    System.out.println(min > 10 ? -1 : min);
    in.close();
  }

  // 문제 분류가 재귀라서 재귀로 풀긴 하는데 재귀보다는 bfs가 효율적인 문제로 보임
  private static void dfs(int dept) {
    if (dept > 10 || dept > min) {
      return;
    }
    dept++;
    int[][] temp = new int[2][2];
    temp[0][0] = coins[0][0];
    temp[0][1] = coins[0][1];
    temp[1][0] = coins[1][0];
    temp[1][1] = coins[1][1];
    for (int[] move : moves) {
      int check = 0;
      for (int i = 0; i < 2; i++) {
        coins[i][0] += move[0];
        coins[i][1] += move[1];
        try {
          if (board[coins[i][0]][coins[i][1]] == '#') {
            coins[i][0] -= move[0];
            coins[i][1] -= move[1];
          }
        } catch (Exception e) {
          check++;
        }
      }
      if (check == 1) {
        if (dept < min) {
          min = dept;
        }
      } else if (check == 0) {
        dfs(dept);
      }
      coins[0][0] = temp[0][0];
      coins[0][1] = temp[0][1];
      coins[1][0] = temp[1][0];
      coins[1][1] = temp[1][1];
    }
  }
}
