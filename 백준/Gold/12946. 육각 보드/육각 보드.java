import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] board;
  static int[][] moves = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
  static int answer;

  public static void main(String[] args) throws IOException {

    N = Integer.parseInt(br.readLine());
    board = new int[N][N];
    answer = 0;
    for (int i = 0; i < N; i++) {
      char[] chars = br.readLine().toCharArray();
      for (int j = 0; j < N; j++) {
        if (chars[j] == 'X') {
          board[i][j] = 1;
          answer = 1;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 1) {
          board[i][j] = 2;
          search(i, j);
        }
      }
    }

    System.out.println(answer);
    br.close();
  }

  static void search(int y, int x) {
    for (int[] m : moves) {
      if (answer < 3) {
        int nextY = y + m[0];
        int nextX = x + m[1];
        if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N && board[nextY][nextX] > 0) {
          if (board[nextY][nextX] == 1) {
            board[nextY][nextX] = 5 - board[y][x];
            answer = 2;
            search(nextY, nextX);
          } else if (board[y][x] == board[nextY][nextX]) {
            answer = 3;
          }
        }
      }
    }
  }
}