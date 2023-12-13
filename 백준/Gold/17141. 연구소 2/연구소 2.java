import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[][] board;
  static ArrayList<int[]> virusPlaceList;
  static boolean[] selectedPlace;
  static int minTime;
  static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N + 2][N + 2];
    virusPlaceList = new ArrayList<>();
    minTime = Integer.MAX_VALUE;

    Arrays.fill(board[0], 1);
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      board[i][0] = 1;
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 2) {
          virusPlaceList.add(new int[] { i, j });
          board[i][j] = 0;
        }
      }
      board[i][N + 1] = 1;
    }
    Arrays.fill(board[N + 1], 1);

    selectedPlace = new boolean[virusPlaceList.size()];
    dfs(0, 0);
    System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);

    br.close();
  }

  static void dfs(int virusCount, int startIndex) {
    if (virusCount == M) {
      ArrayDeque<int[]> bfs = new ArrayDeque<>();
      boolean[][] visited = new boolean[board.length][board.length];
      for (int i = 0; i < selectedPlace.length; i++) {
        if (selectedPlace[i]) {
          int y = virusPlaceList.get(i)[0];
          int x = virusPlaceList.get(i)[1];
          bfs.offer(new int[] { y, x });
          visited[y][x] = true;
        }
      }

      int time = -1;
      while (!bfs.isEmpty()) {
        ArrayDeque<int[]> nextBfsCycle = new ArrayDeque<>();
        while (!bfs.isEmpty()) {
          int[] state = bfs.poll();
          for (int[] m : moves) {
            int ny = state[0] + m[0];
            int nx = state[1] + m[1];
            if (!visited[ny][nx] && board[ny][nx] == 0) {
              visited[ny][nx] = true;
              nextBfsCycle.offer(new int[] { ny, nx });
            }
          }
        }
        time++;
        bfs = nextBfsCycle;
      }
      if (minTime > time) {
        for (int i = 1; i <= N; i++) {
          for (int j = 1; j <= N; j++) {
            if (!visited[i][j] && board[i][j] == 0) {
              return;
            }
          }
        }
        minTime = time;
      }

    } else {
      int restCount = M - virusCount;
      virusCount++;
      for (int i = startIndex; restCount + i <= selectedPlace.length; i++) {
        selectedPlace[i] = true;
        dfs(virusCount, i + 1);
        selectedPlace[i] = false;
      }
    }
  }
}