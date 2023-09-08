import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<Integer>[] graph;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(in.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    for (int i = 1; i <= n; i++) {
      Collections.sort(graph[i]);
    }

    boolean[] visited = new boolean[n + 1];
    dfs(v, visited);
    sb.append("\n");

    Queue<Integer> bfs = new ArrayDeque<>();
    visited = new boolean[n + 1];
    visited[v] = true;
    bfs.offer(v);
    sb.append(v).append(" ");
    while (bfs.size() > 0) {
      int pNode = bfs.poll();

      for (int nextNode : graph[pNode]) {
        if (!visited[nextNode]) {
          visited[nextNode] = true;
          sb.append(nextNode).append(" ");
          bfs.offer(nextNode);
        }
      }
    }

    System.out.println(sb);
    in.close();
  }

  static void dfs(int pNode, boolean[] visited) {
    if (!visited[pNode]) {
      visited[pNode] = true;
      sb.append(pNode).append(" ");
      for (int nextNode : graph[pNode]) {
        if (!visited[nextNode]) {
          dfs(nextNode, visited);
        }
      }
    }
  }
}