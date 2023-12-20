import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    ArrayList<int[]>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    int[] minEdge = new int[] { 0, 0, 1_000_000 };
    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      int[] edge = new int[] { from, to, weight };
      graph[from].add(edge);
      graph[to].add(edge);
      if (minEdge[2] > edge[2]) {
        minEdge = edge;
      }
    }

    HashSet<Integer> houseSet = new HashSet<>();
    houseSet.add(minEdge[0]);
    houseSet.add(minEdge[1]);
    int weightSum = minEdge[2];
    int maxWeight = minEdge[2];

    Queue<int[]> edgePQ = new PriorityQueue<>((e1, e2) -> (e1[2] - e2[2]));
    for (int[] e : graph[minEdge[0]]) {
      edgePQ.offer(e);
    }
    for (int[] e : graph[minEdge[1]]) {
      edgePQ.offer(e);
    }
    loop: while (houseSet.size() < N) {
      while (!edgePQ.isEmpty()) {
        int[] edge = edgePQ.poll();

        if (houseSet.contains(edge[0])) {
          if (!houseSet.contains(edge[1])) {
            houseSet.add(edge[1]);
            weightSum += edge[2];
            if (maxWeight < edge[2]) {
              maxWeight = edge[2];
            }
            for (int[] newEdge : graph[edge[1]]) {
              edgePQ.offer(newEdge);
            }
            continue loop;
          }
        } else if (houseSet.contains(edge[1])) {
          houseSet.add(edge[0]);
          weightSum += edge[2];
          if (maxWeight < edge[2]) {
            maxWeight = edge[2];
          }
          for (int[] newEdge : graph[edge[0]]) {
            edgePQ.offer(newEdge);
          }
          continue loop;
        }
      }
    }

    System.out.println(weightSum - maxWeight);
    br.close();
  }
}