import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];

    st = new StringTokenizer(in.readLine());
    int startY = Integer.parseInt(st.nextToken());
    int startX = Integer.parseInt(st.nextToken());
    int startDir = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    Queue<Integer[]> bfs = new ArrayDeque<>();
    bfs.offer(new Integer[] { startY, startX, startDir });

    while (bfs.size() > 0) {
      Integer[] state = bfs.poll();

      // 현재 칸이 청소 안된 경우
      if (board[state[0]][state[1]] == 0) {
        board[state[0]][state[1]] = 2;
        count++;
      }

      // 주변 4칸에 청소하지 않은 칸이 없는 경우
      if (board[state[0] + 1][state[1]] != 0 && board[state[0]][state[1] + 1] != 0
          && board[state[0] - 1][state[1]] != 0 && board[state[0]][state[1] - 1] != 0) {
        // d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽
        switch (state[2]) {
          case 0:
            if (board[state[0] + 1][state[1]] != 1) {
              bfs.offer(new Integer[] { state[0] + 1, state[1], 0 });
            }
            break;
          case 1:
            if (board[state[0]][state[1] - 1] != 1) {
              bfs.offer(new Integer[] { state[0], state[1] - 1, 1 });
            }
            break;
          case 2:
            if (board[state[0] - 1][state[1]] != 1) {
              bfs.offer(new Integer[] { state[0] - 1, state[1], 2 });
            }
            break;
          case 3:
            if (board[state[0]][state[1] + 1] != 1) {
              bfs.offer(new Integer[] { state[0], state[1] + 1, 3 });
            }
            break;
        }
      } else { // 주변 4칸에 청소하지 않은 칸이 있는 경우
        state[2] = (state[2] + 3) % 4;
        switch (state[2]) {
          case 0:
            if (board[state[0] - 1][state[1]] == 0) {
              bfs.offer(new Integer[] { state[0] - 1, state[1], 0 });
            } else {
              bfs.offer(state);
            }
            break;
          case 1:
            if (board[state[0]][state[1] + 1] == 0) {
              bfs.offer(new Integer[] { state[0], state[1] + 1, 1 });
            } else {
              bfs.offer(state);
            }
            break;
          case 2:
            if (board[state[0] + 1][state[1]] == 0) {
              bfs.offer(new Integer[] { state[0] + 1, state[1], 2 });
            } else {
              bfs.offer(state);
            }
            break;
          case 3:
            if (board[state[0]][state[1] - 1] == 0) {
              bfs.offer(new Integer[] { state[0], state[1] - 1, 3 });
            } else {
              bfs.offer(state);
            }
            break;
        }
      }
    }

    System.out.println(count);
    in.close();
  }
}