import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int X = Integer.parseInt(in.readLine());
    int[] dp = new int[X + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[1] = 0;

    for (int i = 1; i < X; i++) {
      if (i * 3 <= X && dp[i * 3] > dp[i]) {
        dp[i * 3] = dp[i] + 1;
      }
      if ((i << 1) <= X && dp[i << 1] > dp[i]) {
        dp[i << 1] = dp[i] + 1;
      }
      if (dp[i + 1] > dp[i]) {
        dp[i + 1] = dp[i] + 1;
      }
    }

    System.out.println(dp[X]);
    in.close();
  }
}