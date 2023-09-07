import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    int[] inputs = new int[n];
    for (int i = 0; i < n; i++) {
      inputs[i] = Integer.parseInt(in.readLine());
    }

    int[][] dp = new int[n][3];
    dp[0][1] = inputs[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
      dp[i][1] = dp[i - 1][0] + inputs[i];
      dp[i][2] = dp[i - 1][1] + inputs[i];
    }

    System.out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])));
    in.close();
  }
}