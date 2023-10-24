import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    boolean[][] visited = new boolean[n][n];

    StringTokenizer st = new StringTokenizer(in.readLine());
    int[] start = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
    int[] end = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

    if (start[0] == end[0] && start[1] == end[1]) {
      System.out.println(0);
      return;
    }
    if (((start[0] - end[0]) & 1) == 1) {
      System.out.println(-1);
      return;
    }

    int[][] moves = new int[][] { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };

    Queue<int[]> bfs = new ArrayDeque<>(); // {r, c, t}
    bfs.offer(new int[] { start[0], start[1], 0 });
    while (bfs.size() > 0) {
      int[] loc = bfs.poll();
      loc[2]++;
      for (int[] move : moves) {
        int[] nextLoc = new int[] { loc[0] + move[0], loc[1] + move[1], loc[2] };
        if (nextLoc[0] >= 0 && nextLoc[0] < n && nextLoc[1] >= 0 && nextLoc[1] < n
            && !visited[nextLoc[0]][nextLoc[1]]) {
          visited[nextLoc[0]][nextLoc[1]] = true;
          if (nextLoc[0] == end[0] && nextLoc[1] == end[1]) {
            System.out.println(nextLoc[2]);
            return;
          } else {
            bfs.offer(nextLoc);
          }
        }
      }
    }
    System.out.println(-1);
    in.close();
  }
}