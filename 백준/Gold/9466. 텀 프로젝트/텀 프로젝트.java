import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] selects;
  static boolean[] visit;
  static boolean[] cycle;
  static int count;

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int test = 0; test < T; test++) {
      int n = Integer.parseInt(br.readLine());
      selects = new int[n + 1];
      visit = new boolean[n + 1];
      cycle = new boolean[n + 1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        selects[i] = Integer.parseInt(st.nextToken());
      }

      count = n;
      for (int i = 1; i <= n; i++) {
        dfs(i);
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  static void dfs(int now) {
    if (!visit[now]) {
      visit[now] = true;
      int next = selects[now];

      if (visit[next] != true) {
        dfs(next);
      } else {
        if (cycle[next] != true) {
          for (int i = next; i != now; i = selects[i]) {
            count--;
          }
          count--;
        }
      }

      cycle[now] = true;
    }
  }
}