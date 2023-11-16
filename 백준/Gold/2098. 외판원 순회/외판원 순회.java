import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    int[][] graph = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int maxBitmask = (1 << N) - 1;
    int[][] dp = new int[N][1 << N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], 17000000);
    }

    Stack<int[]> dfs = new Stack<>(); // {end, bitmask, weight}
    dfs.push(new int[] { 0, 1, 0 });

    while (dfs.size() > 0) {
      int[] state = dfs.pop();
      for (int nextNode = 0, bitmask = 1; nextNode < N; nextNode++, bitmask <<= 1) {
        if ((bitmask & state[1]) == 0 && graph[state[0]][nextNode] != 0) {
          int nextWeight = state[2] + graph[state[0]][nextNode];
          int nextMask = bitmask | state[1];
          if (dp[nextNode][nextMask] > nextWeight) {
            dp[nextNode][nextMask] = nextWeight;
            dfs.push(new int[] { nextNode, nextMask, nextWeight });
          }
        } else if (state[1] == maxBitmask && 0 == nextNode && graph[state[0]][nextNode] != 0) {
          int nextWeight = state[2] + graph[state[0]][0];
          if (dp[0][maxBitmask] > nextWeight) {
            dp[0][maxBitmask] = nextWeight;
          }
        }
      }
    }

    System.out.println(dp[0][maxBitmask]);
    br.close();
  }
}
