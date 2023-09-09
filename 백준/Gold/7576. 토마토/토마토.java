import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(in.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[][] board = new int[n + 2][m + 2];
    Stack<Tomato> ripeTmtStack = new Stack<>();
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 1; j <= m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 1) {
          ripeTmtStack.push(new Tomato(i, j));
        }
      }
    }
    for (int i = 0; i < board.length; i++) {
      board[i][0] = -1;
      board[i][m + 1] = -1;
    }
    for (int i = 0; i < board[0].length; i++) {
      board[0][i] = -1;
      board[n + 1][i] = -1;
    }

    int dayCount = 0;
    int[] moves = { -1, 1 };
    Queue<Tomato> bfs = new ArrayDeque<>();
    while (!ripeTmtStack.isEmpty()) {
      bfs.offer(ripeTmtStack.pop());
    }

    while (bfs.size() > 0) {
      Tomato state = bfs.poll();
      for (int move : moves) {
        int nextY = state.y + move;
        int nextX = state.x + move;
        if (board[state.y][nextX] == 0) {
          ripeTmtStack.push(new Tomato(state.y, nextX));
          board[state.y][nextX] = 1;
        }
        if (board[nextY][state.x] == 0) {
          ripeTmtStack.push(new Tomato(nextY, state.x));
          board[nextY][state.x] = 1;
        }
      }

      if (bfs.size() == 0 && !ripeTmtStack.isEmpty()) {
        dayCount++;
        while (!ripeTmtStack.isEmpty()) {
          bfs.offer(ripeTmtStack.pop());
        }
      }
    }

    loop: for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (board[i][j] == 0) {
          dayCount = -1;
          break loop;
        }
      }
    }

    System.out.println(dayCount);
    in.close();
  }

  static class Tomato {
    int y;
    int x;

    Tomato(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}