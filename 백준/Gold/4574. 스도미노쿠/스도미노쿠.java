import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int[][] board;
  static HashSet<Domino> dominoSet;
  static boolean isFinish;

  public static void main(String[] args) throws IOException {

    String str;
    StringTokenizer st;
    int puzzleCount = 1;
    while (!(str = in.readLine()).equals("0")) {
      board = new int[9][9];
      dominoSet = new HashSet<>();
      isFinish = false;
      int N = Integer.parseInt(str);
      for (int dominoCount = 1; dominoCount <= N; dominoCount++) {
        st = new StringTokenizer(in.readLine());

        String[] strs = new String[4];
        for (int i = 0; i < 4; i++) {
          strs[i] = st.nextToken();
        }
        Domino domino = new Domino(
            Integer.parseInt(strs[0]), Integer.parseInt(strs[2]),
            (strs[1].charAt(0) - 'A'), (strs[1].charAt(1) - '1'),
            (strs[3].charAt(0) - 'A'), (strs[3].charAt(1) - '1'));
        dominoSet.add(domino);
        board[domino.loc1[0]][domino.loc1[1]] = domino.n1;
        board[domino.loc2[0]][domino.loc2[1]] = domino.n2;
      }
      st = new StringTokenizer(in.readLine());
      for (int i = 1; i <= 9; i++) {
        char[] loc = st.nextToken().toCharArray();
        board[loc[0] - 'A'][loc[1] - '1'] = i;
      }

      sb.append("Puzzle ").append(puzzleCount++).append("\n");
      dfs(0, 0);

    }

    in.close();
    System.out.println(sb);
  }

  static class Domino {
    int n1;
    int n2;
    int[] loc1;
    int[] loc2;

    Domino(int n1, int n2) {
      if (n1 > n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
      }
      this.n1 = n1;
      this.n2 = n2;
    }

    Domino(int n1, int n2, int loc1y, int loc1x, int loc2y, int loc2x) {
      this.loc1 = new int[] { loc1y, loc1x };
      this.loc2 = new int[] { loc2y, loc2x };
      if (n1 > n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
        int[] temps = this.loc1;
        this.loc1 = this.loc2;
        this.loc2 = temps;
      }
      this.n1 = n1;
      this.n2 = n2;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Domino d = (Domino) o;
      return (this.n1 == d.n1 && this.n2 == d.n2);
    }

    @Override
    public int hashCode() {
      return Objects.hash(n1, n2);
    }
  }

  private static void dfs(int y, int x) {
    if (isFinish) {
      return;
    }

    if (x == 9) {
      dfs(y + 1, 0);
      return;
    }

    if (y == 9) {
      appendBoard();
      isFinish = true;
      return;
    }

    if (board[y][x] == 0 && ((x < 8 && board[y][x + 1] == 0) || (y < 8 && board[y + 1][x] == 0))) {
      for (int k = 1; k <= 9; k++) {
        if (valid(y, x, k)) {
          board[y][x] = k;
          for (int l = 1; l <= 9; l++) {
            if (l != k) {
              Domino newDomino = new Domino(k, l);
              if (!dominoSet.contains(newDomino)) {
                dominoSet.add(newDomino);
                if (x < 8 && board[y][x + 1] == 0 && valid(y, x + 1, l)) {
                  board[y][x + 1] = l;
                  dfs(y, x + 1);
                  board[y][x + 1] = 0;
                }
                if (y < 8 && board[y + 1][x] == 0 && valid(y + 1, x, l)) {
                  board[y + 1][x] = l;
                  dfs(y, x + 1);
                  board[y + 1][x] = 0;
                }
                dominoSet.remove(newDomino);
              }
            }
          }
        }
      }
      board[y][x] = 0;
      return;
    }

    dfs(y, x + 1);
  }

  private static boolean valid(int y, int x, int k) {

    for (int i = 0; i < 9; i++) {
      if ((i != y && board[i][x] == k) || (i != x && board[y][i] == k)) {
        return false;
      }
    }
    int startY = y / 3 * 3;
    int startX = x / 3 * 3;
    for (int i = startY; i < startY + 3; i++) {
      for (int j = startX; j < startX + 3; j++) {
        if (board[i][j] == k) {
          return false;
        }
      }
    }

    return true;
  }

  private static void appendBoard() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }
  }
}
