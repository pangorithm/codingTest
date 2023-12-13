import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int[][] board;

  public static void main(String[] args) throws IOException {

    board = new int[9][9];
    for (int i = 0; i < 9; i++) {
      char[] temp = in.readLine().toCharArray();
      for (int j = 0; j < 9; j++) {
        board[i][j] = temp[j] - '0';
      }
    }
    in.close();

    dfs(0, 0);
  }

  private static void dfs(int y, int x) {

    if (x == 9) {
      dfs(y + 1, 0);
      return;
    }

    if (y == 9) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          sb.append(board[i][j]);
        }
        sb.append("\n");
      }
      System.out.println(sb);
      System.exit(0);
    }

    if (board[y][x] == 0) {
      for (int k = 1; k <= 9; k++) {
        if (valid(y, x, k)) {
          board[y][x] = k;
          dfs(y, x + 1);
        }
      }
      board[y][x] = 0;
      return;
    }

    dfs(y, x + 1);
  }

  private static boolean valid(int y, int x, int k) {

    for (int i = 0; i < 9; i++) {
      if ((i != y && board[i][x] == k) || (i != x && board[y][i] == k)) {
        return false;
      }
    }
    int startY = y / 3 * 3;
    int startX = x / 3 * 3;
    for (int i = startY; i < startY + 3; i++) {
      for (int j = startX; j < startX + 3; j++) {
        if (board[i][j] == k) {
          return false;
        }
      }
    }

    return true;
  }
}