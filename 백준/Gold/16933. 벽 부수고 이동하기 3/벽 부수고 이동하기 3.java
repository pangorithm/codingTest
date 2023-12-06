import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    char[][] board = new char[N][M];
    int[][] visited = new int[N][M];
    int[][] wallCrashed = new int[N][M];

    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().toCharArray();
      Arrays.fill(visited[i], 1_000_000_000);
      Arrays.fill(wallCrashed[i], 1_000_000_000);
    }

    if (N == 1 && M == 1) {
      System.out.println(1);
      return;
    }

    int answer = -1;
    int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.offer(new int[] { 0, 0, 0, 1 }); // {y, x, 벽 부순 횟수, 이동 횟수}
    visited[0][0] = 1;
    int lastY = N - 1;
    int lastX = M - 1;
    loop: while (!bfs.isEmpty()) {
      int[] state = bfs.poll();

      state[3]++;
      for (int[] m : moves) {
        int ny = state[0] + m[0];
        int nx = state[1] + m[1];

        if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
          if (ny == lastY && nx == lastX) {
            answer = state[3];
            break loop;
          }

          visited[ny][nx] = state[3];
          int ifCrashWall = state[2] + 1;
          if (board[ny][nx] == '0' &&
              (wallCrashed[ny][nx] > state[2] || (wallCrashed[ny][nx] == state[2] && visited[ny][nx] > state[3]))) {
            wallCrashed[ny][nx] = state[2];
            bfs.offer(new int[] { ny, nx, state[2], state[3] });
          } else if ((state[3] & 1) == 0 && state[2] < K &&
              (wallCrashed[ny][nx] > ifCrashWall
                  || (wallCrashed[ny][nx] == ifCrashWall && visited[ny][nx] > state[3]))) {
            wallCrashed[ny][nx] = ifCrashWall;
            bfs.offer(new int[] { ny, nx, ifCrashWall, state[3] });
          }
        }
      }
      if ((state[3] & 1) == 1) {
        visited[state[0]][state[1]] = state[3];
        bfs.offer(state);
      }
    }

    System.out.println(answer);
    br.close();
  }
}