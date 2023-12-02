import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());
    int[][] board = new int[R][C];

    ArrayList<Integer> airCleaner = new ArrayList<>();
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < C; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
      if (board[i][0] == -1) {
        airCleaner.add(i);
      }
    }

    int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int lastR = R - 1;
    int lastC = C - 1;
    for (int t = 0; t < T; t++) {
      int[][] nextBoard = new int[R][C];
      nextBoard[airCleaner.get(0)][0] = -1;
      nextBoard[airCleaner.get(1)][0] = -1;
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (board[i][j] > 0) {
            nextBoard[i][j] += board[i][j];
            int diff = board[i][j] / 5;

            for (int[] m : moves) {
              int ny = i + m[0];
              int nx = j + m[1];
              if (ny >= 0 && ny < R && nx >= 0 && nx < C && board[ny][nx] != -1) {
                nextBoard[ny][nx] += diff;
                nextBoard[i][j] -= diff;
              }
            }
          }
        }
      }

      // printBoard(nextBoard);

      nextBoard[airCleaner.get(0)][0] = 0;
      for (int i = airCleaner.get(0) - 1; i > 0; i--) {
        nextBoard[i][0] = nextBoard[i - 1][0];
      }
      for (int j = 1; j < C; j++) {
        nextBoard[0][j - 1] = nextBoard[0][j];
      }
      for (int i = 1; i <= airCleaner.get(0); i++) {
        nextBoard[i - 1][lastC] = nextBoard[i][lastC];
      }
      for (int j = C - 1; j > 0; j--) {
        nextBoard[airCleaner.get(0)][j] = nextBoard[airCleaner.get(0)][j - 1];
      }

      nextBoard[airCleaner.get(1)][0] = 0;
      for (int i = airCleaner.get(1) + 1; i < lastR; i++) {
        nextBoard[i][0] = nextBoard[i + 1][0];
      }
      for (int j = 0; j < lastC; j++) {
        nextBoard[lastR][j] = nextBoard[lastR][j + 1];
      }
      for (int i = lastR; i > airCleaner.get(1); i--) {
        nextBoard[i][lastC] = nextBoard[i - 1][lastC];
      }
      for (int j = lastC; j > 0; j--) {
        nextBoard[airCleaner.get(1)][j] = nextBoard[airCleaner.get(1)][j - 1];
      }

      // printBoard(nextBoard);

      board = nextBoard;
    }

    int sum = 0;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        sum += board[i][j];
      }
    }

    System.out.println(sum);

    br.close();
  }

  static void printBoard(int[][] board) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      sb.append(Arrays.toString(board[i])).append("\n");
    }
    System.out.println(sb);
  }
}
