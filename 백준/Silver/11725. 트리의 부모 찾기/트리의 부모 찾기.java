import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<Integer>[] nodes;
  static int[] pNodes;

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(in.readLine());
    int n = Integer.parseInt(st.nextToken());
    nodes = new ArrayList[n + 1];
    pNodes = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      nodes[i] = new ArrayList<Integer>();
    }
    for (int i = 1; i < n; i++) {
      st = new StringTokenizer(in.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      nodes[node1].add(node2);
      nodes[node2].add(node1);
    }

    searchTree(1);

    for (int i = 2; i <= n; i++) {
      sb.append(pNodes[i]).append("\n");
    }

    System.out.println(sb);
    in.close();
  }

  static void searchTree(int pNode) {
    for (Integer cNode : nodes[pNode]) {
      if (pNodes[cNode] == 0) {
        pNodes[cNode] = pNode;
        searchTree(cNode);
      }
    }
  }
}
