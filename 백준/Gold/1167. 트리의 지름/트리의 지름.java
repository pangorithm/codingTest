import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<int[]>[] tree;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int vn = Integer.parseInt(st.nextToken());

    tree = new ArrayList[vn + 1];
    for (int i = 1; i <= vn; i++) {
      tree[i] = new ArrayList<int[]>();
    }
    for (int i = 1; i <= vn; i++) {
      st = new StringTokenizer(in.readLine());
      int pvi = Integer.parseInt(st.nextToken());
      int v;
      int w;
      while ((v = Integer.parseInt(st.nextToken())) != -1) {
        w = Integer.parseInt(st.nextToken());
        tree[pvi].add(new int[] { v, w });
      }
      // System.out.println(pvi);
      // for (int[] temp : tree[pvi]) {
      // System.out.println(Arrays.toString(temp));
      // }
    }

    int max = 0;
    int[] wArr = new int[vn + 1];
    Arrays.fill(wArr, Integer.MAX_VALUE);
    wArr[1] = 0;
    wArr = dist(wArr, 1, 0);
    int node = 0;
    for (int i = 1; i <= vn; i++) {
      if (wArr[i] != Integer.MAX_VALUE && max < wArr[i]) {
        max = wArr[i];
        node = i;
      }
    }

    wArr = new int[vn + 1];
    Arrays.fill(wArr, Integer.MAX_VALUE);
    wArr[node] = 0;
    wArr = dist(wArr, node, 0);
    for (int i = 1; i <= vn; i++) {
      if (wArr[i] != Integer.MAX_VALUE && max < wArr[i]) {
        max = wArr[i];
      }
    }

    System.out.println(max);
    in.close();
  }

  static int[] dist(int[] wArr, int thisV, int weight) {
    for (int[] edge : tree[thisV]) {
      int nextW = weight + edge[1];
      if (nextW <= wArr[edge[0]]) {
        wArr[edge[0]] = nextW;
        wArr = dist(wArr, edge[0], nextW);
      }
    }
    return wArr;
  }
}