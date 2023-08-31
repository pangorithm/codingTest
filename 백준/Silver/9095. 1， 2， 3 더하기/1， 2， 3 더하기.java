import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    int T = Integer.parseInt(in.readLine());
    int[] answer = new int[T];
    int max = 0;
    for (int i = 0; i < T; i++) {
      answer[i] = Integer.parseInt(in.readLine());
      if (max < answer[i]) {
        max = answer[i];
      }
    }

    int[] dp = new int[max + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i <= max; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    for (int i = 0; i < T; i++) {
      sb.append(dp[answer[i]]).append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}