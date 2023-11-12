import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    ArrayList<Integer>[] graph = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    int E = Integer.parseInt(st.nextToken());
    int[][] edges = new int[E][3];
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      edges[i][0] = Integer.parseInt(st.nextToken());
      edges[i][1] = Integer.parseInt(st.nextToken());
      edges[i][2] = Integer.parseInt(st.nextToken());
      graph[edges[i][0]].add(i);
      graph[edges[i][1]].add(i);
    }

    PriorityQueue<Integer> edgePQ = new PriorityQueue<>((e1, e2) -> edges[e1][2] - edges[e2][2]);
    HashSet<Integer> graphSet = new HashSet<>();
    int weight = 0;

    graphSet.add(1);
    for (int e : graph[1]) {
      edgePQ.add(e);
    }

    while (graphSet.size() < V) {
      int edge = edgePQ.poll();
      if (!graphSet.contains(edges[edge][0])) {
        graphSet.add(edges[edge][0]);
        weight += edges[edge][2];

        for (int e : graph[edges[edge][0]]) {
          edgePQ.add(e);
        }
      } else if (!graphSet.contains(edges[edge][1])) {
        graphSet.add(edges[edge][1]);
        weight += edges[edge][2];

        for (int e : graph[edges[edge][1]]) {
          edgePQ.add(e);
        }
      }
    }

    System.out.println(weight);
    br.close();
  }
}