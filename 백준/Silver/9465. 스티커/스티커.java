import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(in.readLine());
    for (int testCase = 0; testCase < t; testCase++) {
      int n = Integer.parseInt(in.readLine());
      int[][] stickers = new int[2][n];
      StringTokenizer st = new StringTokenizer(in.readLine());
      for (int i = 0; i < n; i++) {
        stickers[0][i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(in.readLine());
      for (int i = 0; i < n; i++) {
        stickers[1][i] = Integer.parseInt(st.nextToken());
      }

      int[][] dp = new int[2][n];
      dp[0][0] = stickers[0][0];
      dp[1][0] = stickers[1][0];
      if (n > 1) {
        dp[0][1] = stickers[0][1] + stickers[1][0];
        dp[1][1] = stickers[1][1] + stickers[0][0];
        for (int i = 2; i < n; i++) {
          dp[0][i] = Math.max(dp[1][i - 1] + stickers[0][i], dp[1][i - 2] + stickers[0][i]);
          dp[1][i] = Math.max(dp[0][i - 1] + stickers[1][i], dp[0][i - 2] + stickers[1][i]);
        }
      }

      sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}