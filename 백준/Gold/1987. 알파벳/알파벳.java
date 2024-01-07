import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int count = 0;
  static int[][] moves = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
  static int R;
  static int C;
  static char[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    board = new char[R][C];
    for (int i = 0; i < R; i++) {
      board[i] = br.readLine().toCharArray();
    }

    HashSet<Character> initSet = new HashSet<>();
    initSet.add(board[0][0]);
    search(0, 0, initSet);

    System.out.println(count);
    br.close();
  }

  static void search(int r, int c, HashSet<Character> charSet) {
    if (charSet.size() > count) {
      count = charSet.size();
    }

    for (int[] m : moves) {
      int nr = m[0] + r;
      int nc = m[1] + c;

      if (nr >= 0 && nr < R && nc >= 0 && nc < C && !charSet.contains(board[nr][nc])) {
        charSet.add(board[nr][nc]);
        search(nr, nc, charSet);
        charSet.remove(board[nr][nc]);
      }
    }
  }
}