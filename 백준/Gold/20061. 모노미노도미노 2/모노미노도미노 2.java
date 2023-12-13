import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int score;

  public static void main(String[] args) throws IOException {
    boolean[][] greenBoard = new boolean[6][4];
    boolean[][] blueBoard = new boolean[6][4];
    score = 0;

    int N = Integer.parseInt(br.readLine());
    for (int n = 0; n < N; n++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      addBlock(t, c, greenBoard);
      addBlock(t == 1 ? 1 : 5 - t, r, blueBoard);
    }

    int count = 0;
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 4; j++) {
        if (greenBoard[i][j]) {
          count++;
        }
        if (blueBoard[i][j]) {
          count++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(score).append("\n").append(count);
    System.out.println(sb);
    br.close();
  }

  static void addBlock(int t, int c, boolean[][] board) {

    int maxRow = 2;
    if (t == 2) {
      while (maxRow < 6 && !board[maxRow][c] && !board[maxRow][c + 1]) {
        maxRow++;
      }
    } else {
      while (maxRow < 6 && !board[maxRow][c]) {
        maxRow++;
      }
    }

    maxRow--;
    board[maxRow][c] = true;
    switch (t) {
      case 2:
        board[maxRow][c + 1] = true;
        break;
      case 3:
        board[maxRow - 1][c] = true;
        break;
    }

    for (int i = 2; i < 6; i++) {
      if (board[i][0] && board[i][1] && board[i][2] && board[i][3]) {
        score++;
        moveBlocks(board, i);
      }
    }

    while (board[1][0] || board[1][1] || board[1][2] || board[1][3]) {
      moveBlocks(board, 5);
    }
  }

  static void moveBlocks(boolean[][] board, int r) {
    for (int i = r - 1; i >= 0; i--) {
      for (int j = 0; j < 4; j++) {
        board[i + 1][j] = board[i][j];
      }
    }
    Arrays.fill(board[0], false);
  }

}
