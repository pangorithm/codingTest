import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int k;
  static Queue<Integer[]> bfs;
  static boolean[] dp;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    if (n == k) {
      System.out.println("0");
      return;
    }

    dp = new boolean[100_001];

    bfs = new ArrayDeque<>();
    bfs.offer(new Integer[] { n, 0 });
    while (bfs.size() > 0) {
      Integer[] state = bfs.poll();
      int nextCount = state[1] + 1;
      if (checkNextState(new Integer[] { state[0] + 1, nextCount })) {
        break;
      }
      if (checkNextState(new Integer[] { state[0] - 1, nextCount })) {
        break;
      }
      if (checkNextState(new Integer[] { state[0] << 1, nextCount })) {
        break;
      }
    }

    in.close();
  }

  static boolean checkNextState(Integer[] nextState) {
    if (nextState[0] >= 0 && nextState[0] <= 100_000) {
      if (nextState[0] == k) {
        System.out.println(nextState[1]);
        return true;
      } else if (!dp[nextState[0]]) {
        dp[nextState[0]] = true;
        bfs.offer(nextState);
      }
    }
    return false;
  }
}