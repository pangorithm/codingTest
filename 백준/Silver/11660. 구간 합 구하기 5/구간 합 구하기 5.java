import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] board = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 1; j < N; j++) {
        board[i][j] += board[i][j - 1];
      }
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] += board[i - 1][j];
      }
    }

    // for (int i = 0; i < N; i++) {
    // System.out.println(Arrays.toString(board[i]));
    // }

    StringBuilder sb = new StringBuilder();
    for (int reqCount = 0; reqCount < M; reqCount++) {
      st = new StringTokenizer(in.readLine());
      int y1 = Integer.parseInt(st.nextToken()) - 1;
      int x1 = Integer.parseInt(st.nextToken()) - 1;
      int y2 = Integer.parseInt(st.nextToken()) - 1;
      int x2 = Integer.parseInt(st.nextToken()) - 1;
      sb.append(
          board[y2][x2] - (y1 > 0 ? board[y1 - 1][x2] : 0) - (x1 > 0 ? board[y2][x1 - 1] : 0)
              + (y1 > 0 && x1 > 0 ? board[y1 - 1][x1 - 1] : 0))
          .append("\n");
      // System.out.println((y1 > 0 ? board[y1 - 1][x2] : 0));
      // System.out.println((x1 > 0 ? board[y2][x1 - 1] : 0));
      // System.out.println((y1 > 0 && x1 > 0 ? board[y1 - 1][x1 - 1] : 0));
    }

    System.out.println(sb);
    in.close();
  }
}