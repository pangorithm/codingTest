import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int T = Integer.parseInt(in.readLine());
    int[] inputs = new int[T];
    int max = 0;
    for (int i = 0; i < T; i++) {
      inputs[i] = Integer.parseInt(in.readLine());
      if (max < inputs[i]) {
        max = inputs[i];
      }
    }

    long[][] dp = new long[max + 3][3];
    dp[1][0] = 1; // 1
    dp[2][1] = 1; // 2
    dp[3][2] = 1; // 3

    for (int i = 1; i < max; i++) {
      dp[i + 1][0] = (dp[i + 1][0] + dp[i][1] + dp[i][2]) % 1_000_000_009;
      dp[i + 2][1] = (dp[i + 2][1] + dp[i][0] + dp[i][2]) % 1_000_000_009;
      dp[i + 3][2] = (dp[i + 3][2] + dp[i][0] + dp[i][1]) % 1_000_000_009;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      sb.append((dp[inputs[i]][0] + dp[inputs[i]][1] + dp[inputs[i]][2]) % 1_000_000_009).append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}