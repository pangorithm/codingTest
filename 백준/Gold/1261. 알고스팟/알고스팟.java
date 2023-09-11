import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int m;
  static char[][] board;
  static int[][] dp;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    board = new char[n + 2][m + 2];
    dp = new int[n + 2][m + 2];

    for (int i = 1; i <= n; i++) {
      char[] chars = in.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        board[i][j + 1] = chars[j];
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }
    char check = board[0][0];
    int[] moves = { -1, 1 };
    Queue<Integer[]> bfs = new ArrayDeque<>();
    dp[1][1] = 0;
    bfs.offer(new Integer[] { 1, 1, 0 }); // y, x, count;

    while (bfs.size() > 0) {
      Integer[] state = bfs.poll();

      for (int move : moves) {
        int nextY = state[0] + move;
        int nextX = state[1] + move;
        if (board[nextY][state[1]] != check) {
          Integer[] nextState = new Integer[] { nextY, state[1],
              board[nextY][state[1]] == '0' ? state[2] : state[2] + 1 };
          if (dp[nextState[0]][nextState[1]] > nextState[2]) {
            dp[nextState[0]][nextState[1]] = nextState[2];
            bfs.offer(nextState);
          }
        }
        if (board[state[0]][nextX] != check) {
          Integer[] nextState = new Integer[] { state[0], nextX,
              board[state[0]][nextX] == '0' ? state[2] : state[2] + 1 };
          if (dp[nextState[0]][nextState[1]] > nextState[2]) {
            dp[nextState[0]][nextState[1]] = nextState[2];
            bfs.offer(nextState);
          }
        }
      }
    }

    System.out.println(dp[n][m]);
    in.close();
  }
}
