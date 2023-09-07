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

    int[] dp1 = new int[N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (A[i] > A[j] && dp1[i] < dp1[j]) {
          dp1[i] = dp1[j];
        }
      }
      dp1[i]++;
    }

    int[] dp2 = new int[N];
    for (int i = N - 1; i >= 0; i--) {
      for (int j = N - 1; j > i; j--) {
        if (A[i] > A[j] && dp2[i] < dp2[j]) {
          dp2[i] = dp2[j];
        }
      }
      dp2[i]++;
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      int sum = dp1[i] + dp2[i];
      if (max < sum) {
        max = sum;
      }
    }

    System.out.println(max - 1);
    in.close();
  }
}