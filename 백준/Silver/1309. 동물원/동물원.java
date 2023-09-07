import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(in.readLine());

    int[][] dp = new int[N][3]; // {세로, {해당 라인에 사자 없음, 왼쪽에 있음, 오른쪽에 있음}}
    dp[0][0] = 1;
    dp[0][1] = 1;
    dp[0][2] = 1;
    for (int i = 1; i < N; i++) {
      dp[i][0] = (dp[i - 1][0] + (dp[i - 1][1] + dp[i - 1][2]) % 9901) % 9901;
      dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
      dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
    }

    System.out.println((dp[N - 1][0] + (dp[N - 1][1] + dp[N - 1][2]) % 9901) % 9901);
    in.close();
  }
}