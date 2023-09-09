import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    int[][] moves = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { -2, 1 }, { 1, -2 }, { 2, -1 }, { -1, -2 }, { -2, -1 } };

    int t = Integer.parseInt(in.readLine());
    caseLoop: for (int testCase = 0; testCase < t; testCase++) {

      int length = Integer.parseInt(in.readLine());

      StringTokenizer st = new StringTokenizer(in.readLine());
      int startY = Integer.parseInt(st.nextToken());
      int startX = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(in.readLine());
      int endY = Integer.parseInt(st.nextToken());
      int endX = Integer.parseInt(st.nextToken());

      if (startY == endY && startX == endX) {
        sb.append(0).append("\n");
        continue;
      }

      boolean[][] isVisited = new boolean[length][length];

      Queue<Integer[]> bfs = new ArrayDeque<>();
      bfs.offer(new Integer[] { startY, startX, 0 });
      isVisited[startY][startX] = true;

      while (bfs.size() > 0) {
        Integer[] state = bfs.poll();

        int nextCount = state[2] + 1;
        for (int[] move : moves) {
          int nextY = state[0] + move[0];
          int nextX = state[1] + move[1];

          if (nextY >= 0 && nextY < length && nextX >= 0 && nextX < length && !isVisited[nextY][nextX]) {
            if (nextY == endY && nextX == endX) {
              sb.append(nextCount).append("\n");
              continue caseLoop;
            }
            bfs.offer(new Integer[] { nextY, nextX, nextCount });
            isVisited[nextY][nextX] = true;
          }
        }
      }
    }

    System.out.println(sb);
    in.close();
  }
}