import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(in.readLine());
    loop: for (int t = 0; t < n; t++) {
      StringTokenizer st = new StringTokenizer(in.readLine());

      int v = Integer.parseInt(st.nextToken());
      ArrayList<Integer>[] graph = new ArrayList[v + 1];
      for (int i = 1; i <= v; i++) {
        graph[i] = new ArrayList<>();
      }

      int e = Integer.parseInt(st.nextToken());
      for (int i = 0; i < e; i++) {
        st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        graph[a].add(b);
        graph[b].add(a);
      }

      int[] contains = new int[v + 1];
      Queue<Integer> bfs = new ArrayDeque<>();
      for (int startVertex = 1; startVertex <= v; startVertex++) {
        if (contains[startVertex] != 0) {
          continue;
        }

        bfs.offer(startVertex);
        contains[startVertex] = 1;

        while (bfs.size() > 0) {
          int vertex = bfs.poll();

          for (int nextVertex : graph[vertex]) {
            if (contains[nextVertex] == 0) {
              bfs.offer(nextVertex);
              if (contains[vertex] == 1) {
                contains[nextVertex] = 2;
              } else {
                contains[nextVertex] = 1;
              }

            } else if (contains[vertex] == contains[nextVertex]) {
              sb.append("NO").append("\n");
              continue loop;
            }
          }
        }
      }

      sb.append("YES").append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}
