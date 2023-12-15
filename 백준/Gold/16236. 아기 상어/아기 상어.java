import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] board;
  static boolean[][] visited;
  static Fish babyShark;
  static int babySharkSize;
  static PriorityQueue<Fish> fishPQ;
  static Comparator fishComparator = new Comparator<Fish>() {
    public int compare(Fish f1, Fish f2) {
      if (f1.dist == f2.dist) {
        if (f1.y == f2.y) {
          return f1.x - f2.x;
        } else {
          return f1.y - f2.y;
        }
      } else {
        return f1.dist - f2.dist;
      }
    }
  };
  static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    board = new int[N + 2][N + 2];

    Arrays.fill(board[0], Integer.MAX_VALUE);
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      board[i][0] = Integer.MAX_VALUE;
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 9) {
          board[i][j] = 0;
          babyShark = new Fish(i, j, 0);
        }
      }
      board[i][N + 1] = Integer.MAX_VALUE;
    }
    Arrays.fill(board[N + 1], Integer.MAX_VALUE);
    babySharkSize = 2;

    int moveTime = 0;
    int eatCount = 0;
    while (true) {
      visited = new boolean[N + 2][N + 2];
      searchFishes();
      if (fishPQ.isEmpty()) {
        System.out.println(moveTime);
        break;
      } else {
        // System.out.println(fishPQ);
        Fish ateFish = fishPQ.poll();
        moveTime += ateFish.dist;
        board[babyShark.y][babyShark.x] = 0;
        babyShark.y = ateFish.y;
        babyShark.x = ateFish.x;
        eatCount++;
        if (eatCount == babySharkSize) {
          babySharkSize++;
          eatCount = 0;
        }
      }
    }

    br.close();
  }

  static void searchFishes() {
    fishPQ = new PriorityQueue<>(fishComparator);
    ArrayDeque<Fish> bfs = new ArrayDeque<>();
    bfs.offer(new Fish(babyShark.y, babyShark.x, 0));
    visited[babyShark.y][babyShark.x] = true;
    while (!bfs.isEmpty()) {
      Fish state = bfs.poll();
      state.dist++;

      for (int[] m : moves) {
        int ny = state.y + m[0];
        int nx = state.x + m[1];

        if (!visited[ny][nx] && board[ny][nx] <= babySharkSize) {
          visited[ny][nx] = true;
          Fish nextState = new Fish(ny, nx, state.dist);

          if (fishPQ.isEmpty() || fishPQ.peek().dist >= nextState.dist) {
            if (board[ny][nx] == 0 || board[ny][nx] == babySharkSize) {
              bfs.offer(nextState);
            } else {
              fishPQ.offer(nextState);
            }
          }
        }

      }
    }
  }

  static class Fish {
    int y;
    int x;
    int dist;

    Fish(int y, int x, int dist) {
      this.y = y;
      this.x = x;
      this.dist = dist;
    }

    @Override
    public String toString() {
      return y + " " + x + " " + dist;
    }
  }

}