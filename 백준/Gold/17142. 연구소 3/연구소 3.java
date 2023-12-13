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
      ArrayDeque<Virus> bfs = new ArrayDeque<>();
      boolean[][] visited = new boolean[board.length][board.length];
      HashSet<Virus> disabledVirusSet = new HashSet<>();
      for (int i = 0; i < selectedPlace.length; i++) {
        int y = virusPlaceList.get(i)[0];
        int x = virusPlaceList.get(i)[1];
        if (selectedPlace[i]) {
          bfs.offer(new Virus(y, x, 0));
          visited[y][x] = true;
        } else {
          disabledVirusSet.add(new Virus(y, x, 0));
        }
      }

      int time = 0;
      while (!bfs.isEmpty()) {
        Virus state = bfs.poll();
        if (!disabledVirusSet.contains(state)) {
          time = state.t;
        }
        state.t++;
        for (int[] m : moves) {
          int ny = state.y + m[0];
          int nx = state.x + m[1];
          if (!visited[ny][nx] && board[ny][nx] == 0) {
            visited[ny][nx] = true;
            bfs.offer(new Virus(ny, nx, state.t));
          }
        }
      }

      for (Virus v : disabledVirusSet) {
        visited[v.y][v.x] = true;
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

  static class Virus {
    int y;
    int x;
    int t;

    Virus(int y, int x, int t) {
      this.y = y;
      this.x = x;
      this.t = t;
    }

    @Override
    public int hashCode() {
      return y * board.length + x;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Virus) {
        Virus v = (Virus) obj;
        return v.y == this.y && v.x == this.x;
      }
      return false;
    }
  }

}