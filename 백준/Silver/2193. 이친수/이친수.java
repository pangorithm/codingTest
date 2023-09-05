import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(in.readLine());
    long[][] dp = new long[N + 1][2];

    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 1; i < N; i++) {
      dp[i + 1][0] = dp[i][0] + dp[i][1];
      dp[i + 1][1] = dp[i][0];
    }

    System.out.println(dp[N][0] + dp[N][1]);
    in.close();
  }
}