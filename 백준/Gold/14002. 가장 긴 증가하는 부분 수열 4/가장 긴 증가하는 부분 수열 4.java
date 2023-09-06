import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(in.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[N][2]; // {길이, 이전 원소 인덱스}
    for (int i = 0; i < N; i++) {
      dp[i][1] = -1;
    }
    int[] max = new int[2]; // {길이, 이전 원소 인덱스}
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (A[i] > A[j] && dp[i][0] < dp[j][0]) {
          dp[i][0] = dp[j][0];
          dp[i][1] = j;
        }
      }
      dp[i][0]++;
      if (max[0] < dp[i][0]) {
        max[0] = dp[i][0];
        max[1] = i;
      }
    }

    StringBuilder sb = new StringBuilder();
    int index = max[1];
    while (index != -1) {
      sb.insert(0, " ").insert(0, A[index]);
      index = dp[index][1];
    }
    sb.insert(0, "\n").insert(0, max[0]);

    System.out.println(sb);
    in.close();
  }
}