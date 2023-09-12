import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int m;
  static int nd2;
  static int md2;
  static int[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    nd2 = n >> 1;
    md2 = m >> 1;
    int r = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int cmdCount = 0; cmdCount < r; cmdCount++) {
      f();
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        sb.append(board[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
    in.close();
  }

  static void f() {
    int[][] nextBoard = new int[n][m];

    for (int i = 0; i < nd2; i++) {
      for (int j = i + 1; j < m - i; j++) {
        nextBoard[i][j - 1] = board[i][j];
      }
    }

    for (int j = md2; j < m; j++) {
      for (int i = m - j - 1; i < n - (m - j); i++) {
        nextBoard[i][j] = board[i + 1][j];
      }
    }

    for (int i = nd2; i < n; i++) {
      for (int j = n - i - 1; j < m - (n - i); j++) {
        nextBoard[i][j + 1] = board[i][j];
      }
    }

    for (int j = 0; j < md2; j++) {
      for (int i = j + 1; i < n - j; i++) {
        nextBoard[i][j] = board[i - 1][j];
      }
    }

    board = nextBoard;
  }
}