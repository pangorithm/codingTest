import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] board;
  static int minDiff;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(in.readLine());
    board = new int[N][N];
    minDiff = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(new boolean[N], 0, 0);

    System.out.println(minDiff);
    in.close();
  }

  static void dfs(boolean[] isStartTeam, int count, int startIndex) {
    if (count > 0) {
      int startTeamSum = 0;
      int linkTeamSum = 0;
      for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
          if (!(isStartTeam[i] ^ isStartTeam[j])) {
            if (isStartTeam[i]) {
              startTeamSum += board[i][j];
              startTeamSum += board[j][i];
            } else {
              linkTeamSum += board[i][j];
              linkTeamSum += board[j][i];
            }
          }
        }
      }
      int diff = Math.abs(startTeamSum - linkTeamSum);
      if (minDiff > diff) {
        minDiff = diff;
      }
    }
    if (count < N - 1) {
      count++;
      for (int i = startIndex; i < N; i++) {
        isStartTeam[i] = true;
        dfs(isStartTeam, count, i + 1);
        isStartTeam[i] = false;
      }
    }
  }
}