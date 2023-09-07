import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(in.readLine());
    int[][] inputs = new int[N][3];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      for (int j = 0; j < 3; j++) {
        inputs[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dp = new int[N][3]; // {집번호, 해당 집을 어떤 색으로 칠한 경우인지}
    dp[0][0] = inputs[0][0];
    dp[0][1] = inputs[0][1];
    dp[0][2] = inputs[0][2];
    for (int i = 1; i < N; i++) {
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + inputs[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + inputs[i][1];
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + inputs[i][2];
    }

    System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    in.close();
  }
}
