import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static ArrayList<Integer>[] graph;
  static boolean[] isVisited;
  static boolean[] isCycle;
  static int checkPoint = 0;
  static int[] distances;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    isVisited = new boolean[N + 1];
    isCycle = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      if (!isVisited[i]) {
        boolean[] isVisitedInThisCycle = new boolean[N + 1];
        checkCycle(i, 0, isVisitedInThisCycle);
      }
    }

    distances = new int[N + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    for (int i = 1; i <= N; i++) {
      getDistance(i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(distances[i]).append(" ");
    }
    System.out.println(sb);
    br.close();
  }

  static void getDistance(int node) {
    if (isCycle[node]) {
      distances[node] = 0;
    }
    for (int nextNode : graph[node]) {
      if (distances[nextNode] > distances[node]) {
        distances[nextNode] = distances[node] + 1;
        getDistance(nextNode);
      }
    }
  }

  static boolean checkCycle(int node, int beforeNode, boolean[] isVisitedInThisCycle) {
    isVisited[node] = true;
    isVisitedInThisCycle[node] = true;
    for (int nextNode : graph[node]) {
      if (isVisited[nextNode]) {
        if (isVisitedInThisCycle[nextNode] && nextNode != beforeNode) {
          isCycle[nextNode] = true;
          checkPoint = nextNode;
          return true;
        }
      } else {
        if (checkCycle(nextNode, node, isVisitedInThisCycle)) {
          isCycle[nextNode] = true;
          if (nextNode == checkPoint) {
            return false;
          } else {
            return true;
          }
        }
      }
    }
    return false;
  }
}
