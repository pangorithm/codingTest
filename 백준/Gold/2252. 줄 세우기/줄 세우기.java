import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    ArrayList<Integer>[] nextNodeLists = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      nextNodeLists[i] = new ArrayList<>();
    }
    int[] inDegree = new int[N + 1];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int node = Integer.parseInt(st.nextToken());
      int nextNode = Integer.parseInt(st.nextToken());
      nextNodeLists[node].add(nextNode);
      inDegree[nextNode]++;
    }

    Queue<Integer> que = new ArrayDeque<>();
    ArrayList<Integer> nodeList = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      if (inDegree[i] == 0) {
        que.offer(i);
      }
    }

    while (que.size() > 0) {
      int node = que.poll();
      nodeList.add(node);

      for (int nextNode : nextNodeLists[node]) {
        inDegree[nextNode]--;
        if (inDegree[nextNode] == 0) {
          que.offer(nextNode);
        }
      }
    }

    if (nodeList.size() < N) {
      System.out.println(0);
    } else {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < N; i++) {
        sb.append(nodeList.get(i)).append(" ");
      }
      System.out.println(sb);
    }

    br.close();
  }
}
