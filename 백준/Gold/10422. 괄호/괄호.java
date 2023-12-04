import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    long[] dp = new long[2501];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= 2500; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += (dp[j] * dp[i - 1 - j]);
        dp[i] %= 1_000_000_007;
      }
    }

    dp[0] = 0;

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());
      if ((n & 1) == 0) {
        sb.append(dp[n >> 1]).append("\n");
      } else {
        sb.append(0).append("\n");
      }
    }

    System.out.println(sb);
    br.close();
  }
}