import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static char[][] board;
  static int n;

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(in.readLine());
    board = new char[n + 3][n + 3];
    for (int i = 1; i <= n; i++) {
      char[] temp = in.readLine().toCharArray();
      for (int j = 0; j < n; j++) {
        board[i][j + 1] = temp[j];
      }
    }

    int max = 0;
    char temp = board[1][1];
    int count = 0;
    if (temp != board[1][2]) {
      board[1][1] = board[1][2];
      board[1][2] = temp;
      count = check();
      if (max < count) {
        max = count;
      }
      board[1][2] = board[1][1];
    }
    if (temp != board[2][1]) {
      board[1][1] = board[2][1];
      board[2][1] = temp;
      count = check();
      if (max < count) {
        max = count;
      }
      board[2][1] = board[1][1];
    }
    board[1][1] = temp;

    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= n; j++) {
        temp = board[i][j];
        if (temp != board[i - 1][j]) {
          board[i][j] = board[i - 1][j];
          board[i - 1][j] = temp;
          count = check();
          if (max < count) {
            max = count;
          }
          board[i - 1][j] = board[i][j];
        }
        if (temp != board[i][j - 1]) {
          board[i][j] = board[i][j - 1];
          board[i][j - 1] = temp;
          count = check();
          if (max < count) {
            max = count;
          }
          board[i][j - 1] = board[i][j];
        }
        board[i][j] = temp;
      }
    }

    System.out.println(max);
    in.close();
  }

  static private int check() {
    int max = 0;
    int count = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 2; j <= n + 1; j++) { // 행 체크
        if (board[i][j] != board[i][j - 1]) {
          count = 0;
          for (int k = j - 1; k > 0 && board[i][k] == board[i][j - 1]; k--) {
            count++;
          }
          if (max < count) {
            max = count;
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 2; j <= n + 1; j++) { // 열 체크
        if (board[j][i] != board[j - 1][i]) {
          count = 0;
          for (int k = j - 1; k > 0 && board[k][i] == board[j - 1][i]; k--) {
            count++;
          }
          if (max < count) {
            max = count;
          }
        }
      }
    }

    return max;
  }
}