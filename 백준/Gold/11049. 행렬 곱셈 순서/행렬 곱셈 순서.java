import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    int[][] matrixes = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      matrixes[i][0] = Integer.parseInt(st.nextToken());
      matrixes[i][1] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
      dp[i][i] = 0;
    }

    for (int i = 1; i < N; i++) {
      dp[i - 1][i] = matrixes[i - 1][0] * matrixes[i][0] * matrixes[i][1];
    }

    for (int addLength = 2; addLength < N; addLength++) {
      int end = 0;
      for (int start = 0; (end = start + addLength) < N; start++) {
        for (int mid = start; mid < end; mid++) {
          int sum = dp[start][mid] + dp[mid + 1][end] + matrixes[start][0] * matrixes[mid][1] * matrixes[end][1];
          if (dp[start][end] > sum) {
            dp[start][end] = sum;
          }
        }
      }
    }

    System.out.println(dp[0][N - 1]);
    br.close();
  }
}