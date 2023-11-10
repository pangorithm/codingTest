import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    char[][] board = new char[N][N];
    boolean[][] rgbVisit = new boolean[N][N];
    boolean[][] rbVisit = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().toCharArray();
    }
    br.close();

    int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    Queue<int[]> bfs = new ArrayDeque<>();

    int rgbCount = 0;
    int rbCount = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!rgbVisit[i][j]) {
          rgbCount++;
          rgbVisit[i][j] = true;
          bfs.offer(new int[] { i, j });
          char color = board[i][j];
          while (bfs.size() > 0) {
            int[] loc = bfs.poll();
            for (int[] m : moves) {
              int ny = loc[0] + m[0];
              int nx = loc[1] + m[1];
              if (ny >= 0 && ny < N && nx >= 0 && nx < N && !rgbVisit[ny][nx] && board[ny][nx] == color) {
                rgbVisit[ny][nx] = true;
                bfs.offer(new int[] { ny, nx });
              }
            }
          }
        }

        if (!rbVisit[i][j]) {
          rbCount++;
          rbVisit[i][j] = true;
          bfs.offer(new int[] { i, j });
          char color = board[i][j];
          while (bfs.size() > 0) {
            int[] loc = bfs.poll();
            for (int[] m : moves) {
              int ny = loc[0] + m[0];
              int nx = loc[1] + m[1];
              if (ny >= 0 && ny < N && nx >= 0 && nx < N && !rbVisit[ny][nx]) {
                if (board[ny][nx] == color
                    || ((color == 'R' || color == 'G') && (board[ny][nx] == 'R' || board[ny][nx] == 'G'))) {
                  rbVisit[ny][nx] = true;
                  bfs.offer(new int[] { ny, nx });
                }
              }
            }
          }
        }

      }
    }

    System.out.println(rgbCount + " " + rbCount);
  }
}
