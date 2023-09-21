import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int[][] board = new int[H + X][W + Y];

    for (int i = 0; i < board.length; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        board[i + X][j + Y] -= board[i][j];
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        sb.append(board[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}