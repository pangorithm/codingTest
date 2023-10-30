import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] V = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      V[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[M + 1];
    Arrays.fill(dp, -1);
    dp[S] = 0;
    for (int i = 0; i < N; i++) {
      Stack<Integer> stack = new Stack<>();
      for (int j = 0; j <= M; j++) {
        if (dp[j] == i) {
          if (j + V[i] <= M) {
            stack.push(j + V[i]);
          }
          if (j - V[i] >= 0) {
            stack.push(j - V[i]);
          }
        }
      }
      if (stack.empty()) {
        System.out.println(-1);
        return;
      }
      while (!stack.empty()) {
        dp[stack.pop()] = i + 1;
      }
    }

    int max = -1;
    for (int i = M; i >= 0; i--) {
      if (dp[i] == N) {
        max = i;
        break;
      }
    }

    System.out.println(max);
    br.close();
  }
}
