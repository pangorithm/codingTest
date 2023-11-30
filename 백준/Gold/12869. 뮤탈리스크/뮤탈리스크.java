import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] svcArr = new int[3];
    for (int i = 0; i < N; i++) {
      svcArr[i] = Integer.parseInt(st.nextToken());
    }
    int[][][] dp = new int[svcArr[0] + 1][svcArr[1] + 1][svcArr[2] + 1];
    for (int i = 0; i <= svcArr[0]; i++) {
      for (int j = 0; j <= svcArr[1]; j++) {
        for (int k = 0; k <= svcArr[2]; k++) {
          dp[i][j][k] = 61;
        }
      }
    }
    dp[svcArr[0]][svcArr[1]][svcArr[2]] = 0;

    int[][] attacks = { { 9, 3, 1 }, { 9, 1, 3 }, { 3, 9, 1 }, { 3, 1, 9 }, { 1, 9, 3 }, { 1, 3, 9 } };
    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.offer(new int[] { svcArr[0], svcArr[1], svcArr[2], 0 });
    while (bfs.size() > 0) {
      int[] state = bfs.poll();

      state[3]++;
      for (int[] attack : attacks) {
        int[] nextState = new int[] {
            Math.max(state[0] - attack[0], 0),
            Math.max(state[1] - attack[1], 0),
            Math.max(state[2] - attack[2], 0),
            state[3] };
        if (dp[nextState[0]][nextState[1]][nextState[2]] > nextState[3]) {
          dp[nextState[0]][nextState[1]][nextState[2]] = nextState[3];
          bfs.offer(nextState);
        }
      }
    }

    System.out.println(dp[0][0][0]);
    br.close();
  }
}