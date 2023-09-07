import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    int[] dp = new int[n + 2];
    dp[0] = 1;
    for (int i = 0; i < n; i += 2) {
      dp[i + 2] += dp[i] * 3;
      for (int j = 4; i + j <= n; j += 2) {
        dp[i + j] += dp[i] * 2;
      }
    }

    System.out.println(dp[n]);
    in.close();
  }
}