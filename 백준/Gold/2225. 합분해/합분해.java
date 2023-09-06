import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] dp = new int[N + 1];
    Arrays.fill(dp, 1);
    for (int i = 2; i <= K; i++) {
      for (int j = 1; j <= N; j++) {
        dp[j] = (dp[j - 1] + dp[j]) % 1_000_000_000;
      }
    }

    System.out.println(dp[N]);
    in.close();
  }
}
