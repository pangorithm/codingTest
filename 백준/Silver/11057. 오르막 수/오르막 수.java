import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(in.readLine());
    int[][] dp = new int[N + 1][10];
    Arrays.fill(dp[1], 1);

    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i - 1][0];
      for (int j = 1; j < 10; j++) {
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
      }
    }

    int answer = 0;
    for (int i = 0; i <= 9; i++) {
      answer = (answer + dp[N][i]) % 10007;
    }
    System.out.println(answer);

    in.close();
  }
}