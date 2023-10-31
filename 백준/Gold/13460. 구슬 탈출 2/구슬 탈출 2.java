import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static char[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    int[] red = new int[2];
    int[] blue = new int[2];
    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().toCharArray();
      for (int j = 1; j < M; j++) {
        switch (board[i][j]) {
          case 'R':
            red = new int[] { i, j };
            board[i][j] = '.';
            break;
          case 'B':
            blue = new int[] { i, j };
            board[i][j] = '.';
            break;
        }
      }
    }

    int answer = -1;
    Queue<State> bfs = new ArrayDeque<>();
    bfs.offer(new State(red, blue, 0));
    loop: while (bfs.size() > 0) {
      State state = bfs.poll();
      if (state.count < 10) {
        state.count++;
        int[] nextRed = new int[] { state.red[0], state.red[1] };
        int[] nextBlue = new int[] { state.blue[0], state.blue[1] };
        while (board[nextRed[0] + 1][nextRed[1]] == '.') {
          nextRed[0]++;
        }
        while (board[nextBlue[0] + 1][nextBlue[1]] == '.') {
          nextBlue[0]++;
        }
        if (board[nextBlue[0] + 1][nextBlue[1]] != 'O') {
          if (board[nextRed[0] + 1][nextRed[1]] == 'O') {
            answer = state.count;
            break loop;
          }
          if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
            if (state.red[0] > state.blue[0]) {
              nextBlue[0]--;
            } else {
              nextRed[0]--;
            }
          }
          bfs.offer(new State(nextRed, nextBlue, state.count));
        }

        nextRed = new int[] { state.red[0], state.red[1] };
        nextBlue = new int[] { state.blue[0], state.blue[1] };
        while (board[nextRed[0]][nextRed[1] + 1] == '.') {
          nextRed[1]++;
        }
        while (board[nextBlue[0]][nextBlue[1] + 1] == '.') {
          nextBlue[1]++;
        }
        if (board[nextBlue[0]][nextBlue[1] + 1] != 'O') {
          if (board[nextRed[0]][nextRed[1] + 1] == 'O') {
            answer = state.count;
            break loop;
          }
          if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
            if (state.red[1] > state.blue[1]) {
              nextBlue[1]--;
            } else {
              nextRed[1]--;
            }
          }
          bfs.offer(new State(nextRed, nextBlue, state.count));
        }

        nextRed = new int[] { state.red[0], state.red[1] };
        nextBlue = new int[] { state.blue[0], state.blue[1] };
        while (board[nextRed[0] - 1][nextRed[1]] == '.') {
          nextRed[0]--;
        }
        while (board[nextBlue[0] - 1][nextBlue[1]] == '.') {
          nextBlue[0]--;
        }
        if (board[nextBlue[0] - 1][nextBlue[1]] != 'O') {
          if (board[nextRed[0] - 1][nextRed[1]] == 'O') {
            answer = state.count;
            break loop;
          }
          if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
            if (state.red[0] < state.blue[0]) {
              nextBlue[0]++;
            } else {
              nextRed[0]++;
            }
          }
          bfs.offer(new State(nextRed, nextBlue, state.count));
        }

        nextRed = new int[] { state.red[0], state.red[1] };
        nextBlue = new int[] { state.blue[0], state.blue[1] };
        while (board[nextRed[0]][nextRed[1] - 1] == '.') {
          nextRed[1]--;
        }
        while (board[nextBlue[0]][nextBlue[1] - 1] == '.') {
          nextBlue[1]--;
        }
        if (board[nextBlue[0]][nextBlue[1] - 1] != 'O') {
          if (board[nextRed[0]][nextRed[1] - 1] == 'O') {
            answer = state.count;
            break loop;
          }
          if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
            if (state.red[1] < state.blue[1]) {
              nextBlue[1]++;
            } else {
              nextRed[1]++;
            }
          }
          bfs.offer(new State(nextRed, nextBlue, state.count));
        }
      }
    }

    System.out.println(answer);
    br.close();
  }

  static class State {
    int[] red;
    int[] blue;
    int count;

    State(int[] red, int[] blue, int count) {
      this.red = red;
      this.blue = blue;
      this.count = count;
    }
  }
}
