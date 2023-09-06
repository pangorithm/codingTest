import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int maxLength = 0;

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(in.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (A[i] > A[j] && dp[i] < dp[j]) {
          dp[i] = dp[j];
        }
      }
      dp[i]++;
      if (maxLength < dp[i]) {
        maxLength = dp[i];
      }
    }

    System.out.println(maxLength);
    in.close();
  }

}