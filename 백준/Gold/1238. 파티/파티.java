import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    if (N == 1) {
      System.out.println(0);
      return;
    }

    ArrayList<int[]>[] tree = new ArrayList[N + 1];
    ArrayList<int[]>[] reverseTree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<int[]>();
      reverseTree[i] = new ArrayList<int[]>();
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine());
      int pvi = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      tree[pvi].add(new int[] { v, w });
      reverseTree[v].add(new int[] { pvi, w });
    }

    int[] WXArr = new int[N + 1];
    Arrays.fill(WXArr, Integer.MAX_VALUE);
    WXArr[X] = 0;
    WXArr = dist(WXArr, X, 0, tree);

    int[] RWXArr = new int[N + 1];
    Arrays.fill(RWXArr, Integer.MAX_VALUE);
    RWXArr[X] = 0;
    RWXArr = dist(RWXArr, X, 0, reverseTree);

    int max = 0;
    for (int i = 1; i <= N; i++) {
      max = Math.max(max, WXArr[i] + RWXArr[i]);
    }
    System.out.println(max);
    in.close();
  }

  static int[] dist(int[] wArr, int thisV, int weight, ArrayList<int[]>[] tree) {
    for (int[] edge : tree[thisV]) {
      int nextW = weight + edge[1];
      if (nextW <= wArr[edge[0]]) {
        wArr[edge[0]] = nextW;
        wArr = dist(wArr, edge[0], nextW, tree);
      }
    }
    return wArr;
  }
}