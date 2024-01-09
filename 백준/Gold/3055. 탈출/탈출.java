import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    Queue<int[]> wQue = new ArrayDeque<>();
    Queue<int[]> sQue = new ArrayDeque<>();
    char[][] board = new char[R][C];
    boolean[][] visited = new boolean[R][C];
    for (int i = 0; i < R; i++) {
      board[i] = br.readLine().toCharArray();
      for (int j = 0; j < C; j++) {
        switch (board[i][j]) {
          case '*':
            wQue.offer(new int[] { i, j });
            break;
          case 'S':
            sQue.offer(new int[] { i, j });
            board[i][j] = '.';
            visited[i][j] = true;
            break;
        }
      }
    }

    int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    boolean exited = false;
    loop: for (int time = 1; sQue.size() > 0; time++) {
      Queue<int[]> nextWQ = new ArrayDeque<>();
      while (!wQue.isEmpty()) {
        int[] water = wQue.poll();
        for (int[] m : moves) {
          int ny = water[0] + m[0];
          int nx = water[1] + m[1];
          if (ny >= 0 && ny < R && nx >= 0 && nx < C && board[ny][nx] == '.') {
            board[ny][nx] = '*';
            nextWQ.offer(new int[] { ny, nx });
          }
        }
      }
      wQue = nextWQ;

      Queue<int[]> nextSQ = new ArrayDeque<>();
      while (!sQue.isEmpty()) {
        int[] state = sQue.poll();
        for (int[] m : moves) {
          int ny = state[0] + m[0];
          int nx = state[1] + m[1];
          if (ny >= 0 && ny < R && nx >= 0 && nx < C && !visited[ny][nx] && board[ny][nx] != '*') {
            visited[ny][nx] = true;
            switch (board[ny][nx]) {
              case 'D':
                System.out.println(time);
                exited = true;
                break loop;
              case '.':
                nextSQ.offer(new int[] { ny, nx });
                break;
            }
          }
        }
      }
      sQue = nextSQ;
    }

    if (!exited) {
      System.out.println("KAKTUS");
    }
    br.close();
  }
}
