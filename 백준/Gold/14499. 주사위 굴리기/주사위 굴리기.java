import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb;
  static int n;
  static int m;
  static int x;
  static int y;
  static int k;
  static int[] dice;
  static int[][] diceDir;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    dice = new int[7];
    diceDir = new int[4][3];
    diceDir[1][1] = 1;
    diceDir[0][1] = 2;
    diceDir[1][2] = 3;
    diceDir[1][0] = 4;
    diceDir[2][1] = 5;
    diceDir[3][1] = 6;
    board = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(in.readLine());
    for (int cmdCount = 0; cmdCount < k; cmdCount++) {
      int cmd = Integer.parseInt(st.nextToken());
      switch (cmd) {
        case 1:
          checkValid(x + 1, y, cmd);
          break;
        case 2:
          checkValid(x - 1, y, cmd);
          break;
        case 3:
          checkValid(x, y - 1, cmd);
          break;
        case 4:
          checkValid(x, y + 1, cmd);
          break;
      }
    }

    System.out.println(sb);
    in.close();
  }

  static boolean checkValid(int nextX, int nextY, int cmd) {
    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
      x = nextX;
      y = nextY;
      rotateDice(cmd);

      if (board[y][x] == 0) {
        board[y][x] = dice[diceDir[1][1]];
      } else {
        dice[diceDir[1][1]] = board[y][x];
        board[y][x] = 0;
      }
      sb.append(dice[diceDir[3][1]]).append("\n");
      return true;
    }
    return false;
  }

  static void rotateDice(int cmd) {
    int temp;
    switch (cmd) {
      case 1:
        temp = diceDir[3][1];
        diceDir[3][1] = diceDir[1][0];
        diceDir[1][0] = diceDir[1][1];
        diceDir[1][1] = diceDir[1][2];
        diceDir[1][2] = temp;
        break;
      case 2:
        temp = diceDir[3][1];
        diceDir[3][1] = diceDir[1][2];
        diceDir[1][2] = diceDir[1][1];
        diceDir[1][1] = diceDir[1][0];
        diceDir[1][0] = temp;
        break;
      case 3:
        temp = diceDir[3][1];
        diceDir[3][1] = diceDir[2][1];
        diceDir[2][1] = diceDir[1][1];
        diceDir[1][1] = diceDir[0][1];
        diceDir[0][1] = temp;
        break;
      case 4:
        temp = diceDir[3][1];
        diceDir[3][1] = diceDir[0][1];
        diceDir[0][1] = diceDir[1][1];
        diceDir[1][1] = diceDir[2][1];
        diceDir[2][1] = temp;
        break;
    }
  }
}