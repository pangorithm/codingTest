import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int T = Integer.parseInt(br.readLine());
    int max = 0;
    int[] arr = new int[T];
    for (int i = 0; i < T; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    int[] dp = new int[max + 3];
    dp[0] = 1;
    for (int num = 0; num < max; num++) {
      dp[num + 1] += dp[num];
    }
    for (int num = 0; num < max; num++) {
      dp[num + 2] += dp[num];
    }
    for (int num = 0; num < max; num++) {
      dp[num + 3] += dp[num];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      sb.append(dp[arr[i]]).append("\n");
    }
    System.out.println(sb);
    br.close();
  }
}