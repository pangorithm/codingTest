import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<Integer>[] graph;
  static boolean[] isVisited;
  static int visitCount;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(in.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    isVisited = new boolean[n + 1];
    visitCount = 0;
    int ccc = 0;
    for (int i = 1; i <= n; i++) {
      if (!isVisited[i]) {
        dfs(i);
        ccc++;
      }
    }

    System.out.println(ccc);
    in.close();
  }

  static void dfs(int pNode) {
    if (!isVisited[pNode]) {
      isVisited[pNode] = true;
      for (int nextNode : graph[pNode]) {
        if (!isVisited[nextNode]) {
          dfs(nextNode);
        }
      }
    }
  }
}