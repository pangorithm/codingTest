import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    int[] numbers = new int[N - 2];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int startNum = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N - 2; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    int result = Integer.parseInt(st.nextToken());

    long[] dp = new long[21];
    dp[startNum] = 1;
    for (int num : numbers) {
      long[] newDP = new long[21];
      for (int i = 0; i <= 20; i++) {
        int sum = i + num;
        if (sum >= 0 && sum <= 20) {
          newDP[sum] += dp[i];
        }
        sum = i - num;
        if (sum >= 0 && sum <= 20) {
          newDP[sum] += dp[i];
        }
      }
      dp = newDP;
    }

    System.out.println(dp[result]);
    br.close();
  }
}
