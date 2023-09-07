import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(in.readLine());
    int[] inputs = new int[T];
    int max = 0;
    for (int i = 0; i < T; i++) {
      inputs[i] = Integer.parseInt(in.readLine());
      if (max < inputs[i]) {
        max = inputs[i];
      }
    }

    int[] dp = new int[max + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i <= max; i++) {
      dp[i] = ((dp[i - 1] + dp[i - 2]) % 1_000_000_009 + dp[i - 3]) % 1_000_000_009;
    }

    for (int i = 0; i < T; i++) {
      sb.append(dp[inputs[i]]).append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}