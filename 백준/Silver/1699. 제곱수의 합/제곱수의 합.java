import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    int pow2;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; (pow2 = j * j) <= i; j++) {
        int beforeIndex = i - pow2;
        if (dp[beforeIndex] < dp[i]) {
          dp[i] = dp[beforeIndex];
        }
      }
      dp[i]++;
    }

    System.out.println(dp[n]);
    in.close();
  }
}