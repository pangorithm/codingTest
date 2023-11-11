import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      int[] D = new int[N + 1];
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= N; i++) {
        D[i] = Integer.parseInt(st.nextToken());
      }

      ArrayList<Integer>[] graph = new ArrayList[N + 1];
      ArrayList<Integer>[] needList = new ArrayList[N + 1];
      for (int i = 1; i <= N; i++) {
        graph[i] = new ArrayList<>();
        needList[i] = new ArrayList<>();
      }
      int[] dp = new int[N + 1];
      for (int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        graph[X].add(Y);
        needList[Y].add(X);
        dp[Y] = Integer.MAX_VALUE;
      }

      Queue<Integer> bfs = new ArrayDeque<>();
      for (int i = 1; i <= N; i++) {
        if (dp[i] == 0) {
          dp[i] = Integer.MAX_VALUE;
          bfs.offer(i);
        }
      }
      loop: while (bfs.size() > 0) {
        int state = bfs.poll();
        int max = 0;
        if (dp[state] == Integer.MAX_VALUE) {
          for (int v : needList[state]) {
            if (dp[v] == Integer.MAX_VALUE) {
              continue loop;
            }
            if (dp[v] > max) {
              max = dp[v];
            }
          }
          dp[state] = max + D[state];
          for (int nextState : graph[state]) {
            bfs.offer(nextState);
          }
        }
      }

      sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
