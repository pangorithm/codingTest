import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[][] board;
  static int[][] moves = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
  static int zeroCount;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    ArrayList<int[]> zeroList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 0) {
          zeroList.add(new int[] { i, j });
        }
      }
    }
    zeroCount = zeroList.size();
    int maxCount = 0;
    for (int a = 0; a < zeroCount; a++) {
      int[] aLoc = zeroList.get(a);
      board[aLoc[0]][aLoc[1]] = 1;
      for (int b = a + 1; b < zeroCount; b++) {
        int[] bLoc = zeroList.get(b);
        board[bLoc[0]][bLoc[1]] = 1;
        for (int c = b + 1; c < zeroCount; c++) {
          int[] cLoc = zeroList.get(c);
          board[cLoc[0]][cLoc[1]] = 1;
          maxCount = Math.max(maxCount, check());
          board[cLoc[0]][cLoc[1]] = 0;
        }
        board[bLoc[0]][bLoc[1]] = 0;
      }
      board[aLoc[0]][aLoc[1]] = 0;
    }

    System.out.println(maxCount - 3);
    br.close();
  }

  static int check() {
    boolean[][] visit = new boolean[N][M];
    int count = zeroCount;
    Queue<int[]> bfs = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] == 2) {
          visit[i][j] = true;
          bfs.offer(new int[] { i, j });
          while (bfs.size() > 0) {
            int[] loc = bfs.poll();
            for (int[] m : moves) {
              int[] nextLoc = new int[] { loc[0] + m[0], loc[1] + m[1] };
              if (nextLoc[0] >= 0 && nextLoc[0] < N && nextLoc[1] >= 0 && nextLoc[1] < M) {
                if (board[nextLoc[0]][nextLoc[1]] == 0 && !visit[nextLoc[0]][nextLoc[1]]) {
                  visit[nextLoc[0]][nextLoc[1]] = true;
                  count--;
                  bfs.offer(nextLoc);
                }
              }
            }
          }
        }
      }
    }
    return count;
  }
}
