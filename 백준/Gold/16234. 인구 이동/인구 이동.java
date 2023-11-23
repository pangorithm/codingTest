import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int L;
  static int R;
  static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  static int[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    board = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    boolean finish = false;
    while (!finish) {
      finish = true;
      boolean[][] visit = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visit[i][j]) {
            ArrayDeque<int[]> stack = new ArrayDeque<>();
            Queue<int[]> bfs = new ArrayDeque<>();
            int sum = 0;

            int[] nextState = new int[] { i, j };
            stack.push(nextState);
            bfs.offer(nextState);
            visit[i][j] = true;
            while (bfs.size() > 0) {
              int[] state = bfs.poll();
              int value = board[state[0]][state[1]];
              sum += value;
              for (int[] m : moves) {
                int ny = m[0] + state[0];
                int nx = m[1] + state[1];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                  int dif = Math.abs(value - board[ny][nx]);
                  if (!visit[ny][nx] && dif >= L && dif <= R) {
                    nextState = new int[] { ny, nx };
                    stack.push(nextState);
                    bfs.offer(nextState);
                    visit[ny][nx] = true;
                    finish = false;
                  }
                }
              }
            }
            int avg = sum / stack.size();
            while (stack.size() > 0) {
              int[] state = stack.pop();
              board[state[0]][state[1]] = avg;
            }

          }
        }
      }
      if (!finish) {
        count++;
      }
    }

    System.out.println(count);
    br.close();
  }
}