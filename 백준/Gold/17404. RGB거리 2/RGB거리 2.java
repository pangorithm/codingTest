import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    final int MAX = 1_000_001;

    int N = Integer.parseInt(in.readLine());
    int[][] inputs = new int[N + 1][3];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      for (int j = 0; j < 3; j++) {
        inputs[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][][] dp = new int[N + 1][3][3]; // {집번호, 1번 집의 색, 해당 집을 어떤 색으로 칠한 경우인지}
    dp[1][0][0] = inputs[1][0]; // 1번째 집의 경우 이미 색이 정해져 있음
    dp[1][0][1] = MAX;
    dp[1][0][2] = MAX;

    dp[1][1][0] = MAX;
    dp[1][1][1] = inputs[1][1];
    dp[1][1][2] = MAX;

    dp[1][2][0] = MAX;
    dp[1][2][1] = MAX;
    dp[1][2][2] = inputs[1][2];

    dp[2][0][0] = MAX; // 1번집과 색이 같을 수 없음
    dp[2][0][1] = dp[1][0][0] + inputs[2][1]; // 1번집의 색은 이미 정해져 있음
    dp[2][0][2] = dp[1][0][0] + inputs[2][2];

    dp[2][1][0] = dp[1][1][1] + inputs[2][0];
    dp[2][1][1] = MAX;
    dp[2][1][2] = dp[1][1][1] + inputs[2][2];

    dp[2][2][0] = dp[1][2][2] + inputs[2][0];
    dp[2][2][1] = dp[1][2][2] + inputs[2][1];
    dp[2][2][2] = MAX;

    for (int i = 3; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        dp[i][j][0] = Math.min(dp[i - 1][j][1], dp[i - 1][j][2]) + inputs[i][0];
        dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + inputs[i][1];
        dp[i][j][2] = Math.min(dp[i - 1][j][0], dp[i - 1][j][1]) + inputs[i][2];
      }
    }

    dp[N][0][0] = MAX; // 1번집과 색이 같을 수 없음
    dp[N][0][1] = Math.min(dp[N - 1][0][0], dp[N - 1][0][2]) + inputs[N][1]; // 1번집의 색은 이미 정해져 있음
    dp[N][0][2] = Math.min(dp[N - 1][0][0], dp[N - 1][0][1]) + inputs[N][2];

    dp[N][1][0] = Math.min(dp[N - 1][1][1], dp[N - 1][1][2]) + inputs[N][0];
    dp[N][1][1] = MAX;
    dp[N][1][2] = Math.min(dp[N - 1][1][0], dp[N - 1][1][1]) + inputs[N][2];

    dp[N][2][0] = Math.min(dp[N - 1][2][1], dp[N - 1][2][2]) + inputs[N][0];
    dp[N][2][1] = Math.min(dp[N - 1][2][0], dp[N - 1][2][2]) + inputs[N][1];
    dp[N][2][2] = MAX;

    int answer = MAX;

    for (int j = 0; j < 3; j++) {
      for (int k = 0; k < 3; k++) {
        // System.out.println(dp[N - 1][j][k]);
        if (answer > dp[N][j][k]) {
          answer = dp[N][j][k];
        }
      }
    }

    System.out.println(answer);
    in.close();
  }
}