import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] board = new int[N][M];

    st = new StringTokenizer(in.readLine());
    board[0][0] = Integer.parseInt(st.nextToken());
    for (int j = 1; j < M; j++) {
      board[0][j] = board[0][j - 1] + Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      board[i][0] = board[i - 1][0] + Integer.parseInt(st.nextToken());
      for (int j = 1; j < M; j++) {
        board[i][j] = Math.max(Math.max(board[i][j - 1], board[i - 1][j]), board[i - 1][j - 1])
            + Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(board[N - 1][M - 1]);
    in.close();
  }
}
