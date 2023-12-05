import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int W = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    if (H == 1 && W == 1) {
      System.out.println(0);
      br.close();
      return;
    }

    int[][] board = new int[H][W];
    int[][] mCount = new int[H][W];
    int[][] hCount = new int[H][W];

    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
      Arrays.fill(mCount[i], Integer.MAX_VALUE);
      Arrays.fill(hCount[i], Integer.MAX_VALUE);
    }

    int answer = -1;
    int h = H - 1;
    int w = W - 1;
    int[][] mMoves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int[][] hMoves = { { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 } };
    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.offer(new int[4]);
    board[0][0] = 1;
    loop: while (bfs.size() > 0) {
      int[] state = bfs.poll();

      state[2]++;
      for (int[] m : mMoves) {
        int ny = state[0] + m[0];
        int nx = state[1] + m[1];
        if (ny >= 0 && ny < H && nx >= 0 && nx < W && board[ny][nx] == 0) {
          if (ny == h && nx == w) {
            answer = state[2];
            break loop;
          }
          if (hCount[ny][nx] > state[3] || (hCount[ny][nx] == state[3] && mCount[ny][nx] > state[2])) {
            mCount[ny][nx] = state[2];
            hCount[ny][nx] = state[3];
            bfs.offer(new int[] { ny, nx, state[2], state[3] });
          }
        }
      }

      if (state[3] < K) {
        state[3]++;
        for (int[] m : hMoves) {
          int ny = state[0] + m[0];
          int nx = state[1] + m[1];
          if (ny >= 0 && ny < H && nx >= 0 && nx < W && board[ny][nx] == 0 && hCount[ny][nx] > state[3]) {
            if (ny == h && nx == w) {
              answer = state[2];
              break loop;
            }
            mCount[ny][nx] = state[2];
            hCount[ny][nx] = state[3];
            bfs.offer(new int[] { ny, nx, state[2], state[3] });
          }
        }
      }
    }

    System.out.println(answer);
    br.close();
  }
}