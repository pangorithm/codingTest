import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[][] moves = { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 } };
  static int[][] dp;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int[][] board = new int[N][M];
    dp = new int[N][M];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    Queue<int[]> bfs = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 1) {
          dp[i][j] = 0;
          bfs.offer(new int[] { i, j, 0 });
        }
      }
    }

    while (bfs.size() > 0) {
      int[] state = bfs.poll();
      state[2]++;
      for (int[] move : moves) {
        int[] nextState = new int[] { state[0] + move[0], state[1] + move[1], state[2] };
        if (nextState[0] >= 0 && nextState[0] < N && nextState[1] >= 0 && nextState[1] < M
            && nextState[2] < dp[nextState[0]][nextState[1]]) {
          dp[nextState[0]][nextState[1]] = nextState[2];
          bfs.offer(nextState);
        }
      }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (max < dp[i][j]) {
          max = dp[i][j];
        }
      }
    }

    System.out.println(max);
    in.close();
  }
}