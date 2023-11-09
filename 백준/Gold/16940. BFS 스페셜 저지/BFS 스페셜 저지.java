import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static HashSet<Integer>[] graph;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    graph = new HashSet[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new HashSet<Integer>();
    }

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    int[] visitOrder = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      visitOrder[i] = Integer.parseInt(st.nextToken());
    }

    Queue<Integer> visitQue = new ArrayDeque<>();
    visitQue.offer(1);
    int index = 1;
    while (visitQue.size() > 0) {
      int node = visitQue.poll();
      while (!graph[node].isEmpty()) {
        int nextNode = visitOrder[index++];
        if (graph[node].contains(nextNode)) {
          graph[node].remove(nextNode);
          graph[nextNode].remove(node);
          visitQue.offer(nextNode);
        } else {
          System.out.println(0);
          return;
        }
      }
    }

    System.out.println(1);
    br.close();
  }
}
