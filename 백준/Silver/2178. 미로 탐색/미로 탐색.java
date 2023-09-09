import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(in.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    char[][] board = new char[n + 2][m + 2];
    for (int i = 1; i <= n; i++) {
      char[] chars = in.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        board[i][j + 1] = chars[j];
      }
    }

    Queue<Integer[]> bfs = new ArrayDeque<>();
    bfs.offer(new Integer[] { 1, 1, 1 });
    board[1][1] = '0';
    int[] moves = { -1, 1 };

    while (bfs.size() > 0) {
      Integer[] state = bfs.poll();
      int nextMoveCount = state[2] + 1;
      for (int move : moves) {
        int nextY = state[0] + move;
        int nextX = state[1] + move;
        if (board[state[0]][nextX] == '1') {
          if (state[0] == n && nextX == m) {
            System.out.println(nextMoveCount);
            in.close();
            return;
          }
          bfs.offer(new Integer[] { state[0], nextX, nextMoveCount });
          board[state[0]][nextX] = '0';
        }
        if (board[nextY][state[1]] == '1') {
          if (nextY == n && state[1] == m) {
            System.out.println(nextMoveCount);
            in.close();
            return;
          }
          bfs.offer(new Integer[] { nextY, state[1], nextMoveCount });
          board[nextY][state[1]] = '0';
        }
      }
    }
  }
}