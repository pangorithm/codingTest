import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    int[] dp = new int[n + 3];
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 1; i < n; i++) {
      dp[i + 1] = (dp[i + 1] + dp[i]) % 10_007;
      dp[i + 2] = (dp[i + 2] + dp[i]) % 10_007;
    }

    System.out.println(dp[n]);
    in.close();
  }
}