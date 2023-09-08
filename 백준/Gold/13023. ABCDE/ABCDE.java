import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<Integer>[] graph;
  static boolean[] isVisited;
  static boolean valid;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int n = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n];
    isVisited = new boolean[n];
    valid = false;
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    int m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(in.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    for (int i = 0; i < n; i++) {
      isVisited[i] = true;
      dfs(1, graph[i]);
      isVisited[i] = false;
    }

    System.out.println(valid ? "1" : "0");
    in.close();
  }

  static void dfs(int dept, ArrayList<Integer> list) {
    if (valid) {
      return;
    }

    if (dept == 5) {
      valid = true;
      return;
    } else {
      dept++;
      for (int i : list) {
        if (!isVisited[i]) {
          isVisited[i] = true;
          dfs(dept, graph[i]);
          isVisited[i] = false;
        }
      }
    }
  }
}