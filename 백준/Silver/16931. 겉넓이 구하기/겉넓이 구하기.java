import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N + 2][M + 2];

    int area = 0;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 1; j <= M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] > 0) {
          area += 2;
        }
      }
    }

    for (int i = 0; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        area += Math.abs(board[i][j] - board[i + 1][j]);
      }
    }

    for (int j = 0; j <= M; j++) {
      for (int i = 1; i <= N; i++) {
        area += Math.abs(board[i][j] - board[i][j + 1]);
      }
    }

    System.out.println(area);
    in.close();
  }
}