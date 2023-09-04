import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] matrix;
  static boolean[] visited;
  static int min;

  public static void main(String[] args) throws IOException {

    N = Integer.parseInt(in.readLine());
    matrix = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      for (int j = 0; j < N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    visited = new boolean[N];
    min = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      dfs(0, i, 0, i);
    }

    System.out.println(min);
    in.close();
  }

  static void dfs(int sum, int lastVisit, int dept, int startNode) {
    if (dept == N && lastVisit == startNode && sum < min) {
      min = sum;
    } else {
      dept++;
      for (int i = 0; i < N; i++) {
        if (!visited[i] && matrix[lastVisit][i] != 0) {
          visited[i] = true;
          dfs(sum + matrix[lastVisit][i], i, dept, startNode);
          visited[i] = false;
        }
      }
    }
  }
}