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

    int maxL = (n << 1) + (m << 1) - 4;
    for (int dept = 0; dept < Math.min(nd2, md2); dept++) {
      for (int cmdCount = 0; cmdCount < r % maxL; cmdCount++) {
        f(dept);
      }
      maxL -= 8;
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

  static void f(int dept) {
    int temp = board[dept][dept];
    for (int j = dept + 1; j < m - dept; j++) {
      board[dept][j - 1] = board[dept][j];
    }
    int lastIndex = m - 1;
    for (int i = dept + 1; i < n - dept; i++) {
      board[i - 1][lastIndex - dept] = board[i][lastIndex - dept];
    }
    lastIndex = n - 1;
    for (int j = m - dept - 1; j > dept; j--) {
      board[lastIndex - dept][j] = board[lastIndex - dept][j - 1];
    }
    for (int i = n - dept - 1; i > dept; i--) {
      board[i][dept] = board[i - 1][dept];
    }
    board[dept + 1][dept] = temp;
  }
}
