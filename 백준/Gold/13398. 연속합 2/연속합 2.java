import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int max = arr[0];
    int[][] dp = new int[n][2];
    dp[0][0] = arr[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
      dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

      max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
    }

    System.out.println(max);
    in.close();
  }
}
