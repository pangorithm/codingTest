import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] consulting;
  static int max;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(in.readLine());
    consulting = new int[N][2];
    max = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      consulting[i][0] = Integer.parseInt(st.nextToken());
      consulting[i][1] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);

    System.out.println(max);
    in.close();
  }

  static void dfs(int sum, int startIndex) {
    for (int i = startIndex; i < N; i++) {
      int nextIndex = i + consulting[i][0];
      int nextSum = sum + consulting[i][1];
      if (nextIndex <= N) {
        if (nextIndex < N) {
          dfs(nextSum, nextIndex);
        }
        if (max < nextSum) {
          max = nextSum;
        }
      }
    }
  }
}