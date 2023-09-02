import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int n;
  static char[][] board;
  static int[] signs;
  static boolean finded;

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(in.readLine());
    board = new char[n][n];
    char[] inputs = in.readLine().toCharArray();
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        board[i][j] = inputs[index++];
      }
    }
    signs = new int[n];
    for (int i = 0; i < n; i++) {
      if (board[i][i] == '+') {
        signs[i] = 1;
      } else if (board[i][i] == '-') {
        signs[i] = -1;
      }
    }

    dfs(new int[n], 0);

    System.out.println(sb);
    in.close();
  }

  static void dfs(int[] nums, int dept) {
    if (finded) {
      return;
    }
    if (dept == n) {
      if (check(nums, dept - 1)) {
        finded = true;
        for (int i = 0; i < n; i++) {
          sb.append(nums[i]).append(" ");
        }
        sb.append("\n");
      }
    } else {
      if (signs[dept] == 0) {
        dfs(nums, dept + 1);
      } else {
        for (int i = 1; i <= 10; i++) {
          nums[dept] = i * signs[dept];
          if (check(nums, dept)) {
            dfs(nums, dept + 1);
          }
        }
      }
    }
  }

  static boolean check(int[] nums, int dept) {
    for (int i = 0; i <= dept; i++) {
      for (int j = i; j <= dept; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += nums[k];
        }
        if (board[i][j] == '-') {
          if (sum >= 0) {
            return false;
          }
        } else if (board[i][j] == '+') {
          if (sum <= 0) {
            return false;
          }
        } else {
          if (sum != 0) {
            return false;
          }
        }
      }
    }
    return true;
  }
}