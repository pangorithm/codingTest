import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static boolean[][] board;

  public static void main(String[] args) throws IOException {

    board = new boolean[101][101];
    int n = Integer.parseInt(in.readLine());
    for (int dcc = 0; dcc < n; dcc++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());

      ArrayList<Integer[]> moveList = new ArrayList<>();
      switch (d) {
        case 0:
          moveList.add(new Integer[] { 0, 1 });
          break;
        case 1:
          moveList.add(new Integer[] { -1, 0 });
          break;
        case 2:
          moveList.add(new Integer[] { 0, -1 });
          break;
        case 3:
          moveList.add(new Integer[] { 1, 0 });
          break;
      }

      for (int i = 0; i < g; i++) {
        for (int j = moveList.size() - 1; j >= 0; j--) {
          Integer[] move = moveList.get(j);
          moveList.add(new Integer[] { -move[1], move[0] });
        }
      }

      board[y][x] = true;
      for (int i = 0; i < moveList.size(); i++) {
        Integer[] move = moveList.get(i);
        y += move[0];
        x += move[1];
        board[y][x] = true;
      }

    }

    int count = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
          count++;
        }
      }
    }

    System.out.println(count);
    in.close();
  }
}
