import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  static int N;
  static int M;
  static char[][] board;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          visited[i][j] = true;
          dfs(i, j, -1, -1);
        }
      }
    }

    System.out.println("No");
    br.close();
  }

  static void dfs(int y, int x, int preY, int preX) {
    for (int[] move : moves) {
      int nextY = y + move[0];
      int nextX = x + move[1];
      if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && board[y][x] == board[nextY][nextX]) {
        if (visited[nextY][nextX]) {
          if (nextY != preY || nextX != preX) {
            System.out.println("Yes");
            System.exit(0);
          }
        } else {
          visited[nextY][nextX] = true;
          dfs(nextY, nextX, y, x);
        }
      }
    }
  }
}