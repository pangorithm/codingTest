import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static char[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    for (int i = 0; i < N; i++) {
      board[i] = in.readLine().toCharArray();
    }

    int min = Integer.MAX_VALUE;

    for (int i = 0; i <= N - 8; i++) {
      for (int j = 0; j <= M - 8; j++) {
        int count = 0;
        for (int y = i; y < i + 8; y++) {
          for (int x = j; x < j + 8; x++) {
            if (((i + j) & 1) == ((y + x) & 1)) {
              if (board[i][j] != board[y][x]) {
                count++;
              }
            } else {
              if (board[i][j] == board[y][x]) {
                count++;
              }
            }
          }
        }
        count = Math.min(count, 64 - count);
        min = Math.min(count, min);
      }
    }

    System.out.println(min);
    in.close();
  }
}