import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int k;
  static Queue<Integer[]> bfs;
  static int[] dp;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    if (n == k) {
      System.out.println("0");
      return;
    }

    dp = new int[100_001];
    Arrays.fill(dp, Integer.MAX_VALUE);

    bfs = new ArrayDeque<>();
    bfs.offer(new Integer[] { n, 0 });
    dp[n] = 0;

    while (bfs.size() > 0) {
      Integer[] state = bfs.poll();
      int nextCount = state[1] + 1;
      checkNextState(new Integer[] { state[0] + 1, nextCount });
      checkNextState(new Integer[] { state[0] - 1, nextCount });
      checkNextState(new Integer[] { state[0] << 1, state[1] });
    }

    System.out.println(dp[k]);
    in.close();
  }

  static void checkNextState(Integer[] nextState) {
    if (nextState[0] >= 0 && nextState[0] <= 100_000) {
      if (dp[nextState[0]] > nextState[1]) {
        dp[nextState[0]] = nextState[1];
        bfs.offer(nextState);
      }
    }
  }
}