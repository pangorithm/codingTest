import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] dp = new int[101];

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<Integer, Integer> ladderMap = new HashMap<>();
    HashMap<Integer, Integer> snakeMap = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      ladderMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      snakeMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    Arrays.fill(dp, Integer.MAX_VALUE);
    br.close();

    Queue<int[]> bfs = new ArrayDeque<>(); // {위치, 횟수}
    bfs.offer(new int[] { 1, 0 });
    while (bfs.size() > 0) {
      int[] state = bfs.poll();
      state[1]++;
      for (int i = 1; i <= 6; i++) {
        int nextLoc = state[0] + i;
        if (nextLoc == 100) {
          System.out.println(state[1]);
          return;
        } else if (nextLoc < 100) {
          if (ladderMap.containsKey(nextLoc)) {
            nextLoc = ladderMap.get(nextLoc);
          } else if (snakeMap.containsKey(nextLoc)) {
            nextLoc = snakeMap.get(nextLoc);
          }
          if (dp[nextLoc] > state[1]) {
            dp[nextLoc] = state[1];
            bfs.offer(new int[] { nextLoc, state[1] });
          }
        }
      }
    }

  }
}
