import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    long[] dp = new long[5001];
    dp[0] = 1;
    dp[2] = 1;
    dp[4] = 2;
    for (int i = 6; i <= 5000; i += 2) {
      for (int j = 0; j < i; j += 2) {
        dp[i] += (dp[j] * dp[i - 2 - j]);
        dp[i] %= 1_000_000_007;
      }
    }

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 0; t < T; t++) {
      sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}