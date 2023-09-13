import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int L;
  static int[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    board = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    loop: for (int i = 0; i < N; i++) { // 행 탐색
      boolean[] dp = new boolean[N];
      for (int x = 1; x < N; x++) {
        int min;
        int max;
        if (board[i][x] > board[i][x - 1]) {
          min = x - 1;
          max = x;
        } else {
          min = x;
          max = x - 1;
        }
        int dif = board[i][max] - board[i][min];
        if (dif > 1) {
          continue loop;
        } else if (dif == 1) {
          if (min == x) {
            for (int w = x; w < x + L; w++) {
              if (w == N || board[i][x] != board[i][w] || dp[w]) {
                continue loop;
              }
            }
            for (int w = x; w < x + L; w++) {
              dp[w] = true;
            }
          } else {
            for (int w = min; w >= x - L; w--) {
              if (w == -1 || board[i][min] != board[i][w] || dp[w]) {
                continue loop;
              }
            }
            for (int w = min; w >= x - L; w--) {
              dp[w] = true;
            }
          }
        }
      }
      count++;
    }

    loop: for (int j = 0; j < N; j++) { // 열 탐색
      boolean[] dp = new boolean[N];
      for (int x = 1; x < N; x++) {
        int min;
        int max;
        if (board[x][j] > board[x - 1][j]) {
          min = x - 1;
          max = x;
        } else {
          min = x;
          max = x - 1;
        }
        int dif = board[max][j] - board[min][j];
        if (dif > 1) {
          continue loop;
        } else if (dif == 1) {
          if (min == x) {
            for (int w = x; w < x + L; w++) {
              if (w == N || board[x][j] != board[w][j] || dp[w]) {
                continue loop;
              }
            }
            for (int w = x; w < x + L; w++) {
              dp[w] = true;
            }
          } else {
            for (int w = min; w >= x - L; w--) {
              if (w == -1 || board[min][j] != board[w][j] || dp[w]) {
                continue loop;
              }
            }
            for (int w = min; w >= x - L; w--) {
              dp[w] = true;
            }
          }
        }
      }
      count++;
    }

    System.out.println(count);
    in.close();
  }
}