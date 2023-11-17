import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(in.readLine());
    int[][][] dp = new int[N + 1][1 << 10][10];
    int maxBitmask = (1 << 10) - 1;
    for (int i = 1, bitmask = 2; i < 10; i++, bitmask <<= 1) {
      dp[1][bitmask][i] = 1;
    }

    for (int i = 1; i < N; i++) {
      for (int j = 1; j <= maxBitmask; j++) {
        int bitmask = 1;
        dp[i + 1][j | bitmask][0] = (dp[i + 1][j | bitmask][0] + dp[i][j][1]) % 1_000_000_000;
        for (int k = 1; k < 9; k++) {
          bitmask <<= 1;
          dp[i + 1][j | bitmask][k] = (dp[i + 1][j | bitmask][k] + (dp[i][j][k - 1] + dp[i][j][k + 1]) % 1_000_000_000)
              % 1_000_000_000;
        }
        bitmask <<= 1;
        dp[i + 1][j | bitmask][9] = (dp[i + 1][j | bitmask][9] + dp[i][j][8]) % 1_000_000_000;
      }
    }

    int sum = 0;
    for (int i = 0; i < 10; i++) {
      sum = (sum + dp[N][maxBitmask][i]) % 1_000_000_000;
    }

    System.out.println(sum);
    in.close();
  }
}