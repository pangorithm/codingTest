import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    int[] dp = new int[N];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.offer(new int[] { 0, 0 });
    while (bfs.size() > 0) {
      int[] state = bfs.poll();
      state[1]++;

      for (int i = 1; i <= A[state[0]]; i++) {
        int[] nextState = new int[] { state[0] + i, state[1] };
        if (nextState[0] < N && nextState[1] < dp[nextState[0]]) {
          dp[nextState[0]] = nextState[1];
          bfs.offer(nextState);
        }
      }
    }

    if (dp[N - 1] == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(dp[N - 1]);
    }
    br.close();
  }
}