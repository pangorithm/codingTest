import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int F = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int G = Integer.parseInt(st.nextToken());
    int U = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    if (check(new int[] { S, 0 }, G)) {
      return;
    }

    int[] upF = new int[F + 1];
    int[] downF = new int[F + 1];

    for (int i = 1; i <= F; i++) {
      upF[i] = i + U;
      downF[i] = i - D;
    }

    boolean[] visited = new boolean[F + 1];
    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.offer(new int[] { S, 0 });
    while (bfs.size() > 0) {
      int[] state = bfs.poll();
      state[1]++;

      if (upF[state[0]] <= F) {
        int[] nextState = new int[] { upF[state[0]], state[1] };
        if (check(nextState, G)) {
          return;
        } else if (!visited[upF[state[0]]]) {
          bfs.offer(nextState);
          visited[upF[state[0]]] = true;
        }
      }

      if (downF[state[0]] > 0) {
        int[] nextState = new int[] { downF[state[0]], state[1] };
        if (check(nextState, G)) {
          return;
        } else if (!visited[downF[state[0]]]) {
          bfs.offer(nextState);
          visited[downF[state[0]]] = true;
        }
      }
    }

    System.out.println("use the stairs");
    in.close();
  }

  static boolean check(int[] state, int g) {
    if (state[0] == g) {
      System.out.println(state[1]);
      return true;
    } else {
      return false;
    }
  }
}