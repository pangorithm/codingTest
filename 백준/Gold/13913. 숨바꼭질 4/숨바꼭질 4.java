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
      StringBuilder sb = new StringBuilder();
      sb.append(0).append("\n").append(n).append("\n");
      System.out.println(sb);
      return;
    }

    dp = new int[100_001];
    Arrays.fill(dp, -2);

    bfs = new ArrayDeque<>();
    bfs.offer(new Integer[] { n, 0, -1 });
    dp[n] = -1;
    while (bfs.size() > 0) {
      Integer[] state = bfs.poll();
      int nextCount = state[1] + 1;
      if (checkNextState(new Integer[] { state[0] + 1, nextCount, state[0] })) {
        break;
      }
      if (checkNextState(new Integer[] { state[0] - 1, nextCount, state[0] })) {
        break;
      }
      if (checkNextState(new Integer[] { state[0] << 1, nextCount, state[0] })) {
        break;
      }
    }

    in.close();
  }

  static boolean checkNextState(Integer[] nextState) {
    if (nextState[0] >= 0 && nextState[0] <= 100_000) {
      if (dp[nextState[0]] == -2) {
        dp[nextState[0]] = nextState[2];
        if (nextState[0] == k) {
          StringBuilder sb = new StringBuilder();
          int index = nextState[0];
          sb.append(nextState[0]).append("\n");
          while (dp[index] != -1) {
            sb.insert(0, " ").insert(0, dp[index]);
            index = dp[index];
          }
          sb.insert(0, "\n").insert(0, nextState[1]);
          System.out.println(sb);
          return true;
        }
        bfs.offer(nextState);
      }
    }
    return false;
  }
}