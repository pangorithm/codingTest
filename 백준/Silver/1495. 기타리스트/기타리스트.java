import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] V = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      V[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<Integer> list = new ArrayList<>();
    Queue<int[]> bfs = new ArrayDeque<>(); // {index, volume}
    bfs.offer(new int[] { 0, S });
    int index = 0;
    boolean[] visited = new boolean[M + 1];
    while (bfs.size() > 0) {
      int[] state = bfs.poll();
      if (index != state[0]) {
        index = state[0];
        visited = new boolean[M + 1];
      }
      if (state[0] < N) {
        int volume = state[1] + V[state[0]];
        if (volume <= M && !visited[volume]) {
          bfs.offer(new int[] { state[0] + 1, volume });
          visited[volume] = true;
        }
        volume = state[1] - V[state[0]];
        if (volume >= 0 && !visited[volume]) {
          bfs.offer(new int[] { state[0] + 1, volume });
          visited[volume] = true;
        }
      } else {
        list.add(state[1]);
      }
    }

    int max = -1;
    for (int v : list) {
      if (max < v) {
        max = v;
      }
    }
    System.out.println(max);
    br.close();
  }
}
