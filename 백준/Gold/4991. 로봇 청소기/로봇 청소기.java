import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      if (w == 0 || h == 0) {
        break;
      }

      ArrayList<Location> locList = new ArrayList<>();
      HashMap<Location, Integer> locIndexMap = new HashMap<>();
      int index = 1;
      char[][] board = new char[h + 2][w + 2];
      Arrays.fill(board[0], 'x');
      for (int i = 1; i <= h; i++) {
        board[i] = new StringBuilder().append('x').append(br.readLine()).append('x').toString().toCharArray();
        for (int j = 1; j <= w; j++) {
          if (board[i][j] == '*') {
            Location loc = new Location(i, j, 0);
            locList.add(loc);
            locIndexMap.put(loc, index++);
          } else if (board[i][j] == 'o') {
            Location loc = new Location(i, j, 0);
            locList.add(0, loc);
            locIndexMap.put(loc, 0);
          }
        }
      }
      Arrays.fill(board[h + 1], 'x');

      int[][] moves = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
      int[][] graph = new int[locList.size()][locList.size()];
      for (int startIndex = 0; startIndex < locList.size(); startIndex++) {
        Location loc = locList.get(startIndex);
        boolean[][] visited = new boolean[board.length][board[0].length];
        ArrayDeque<Location> bfs = new ArrayDeque<>();
        bfs.offer(loc);
        visited[loc.y][loc.x] = true;
        while (!bfs.isEmpty()) {
          Location state = bfs.poll();
          state.t++;
          for (int[] m : moves) {
            int ny = state.y + m[0];
            int nx = state.x + m[1];
            if (!visited[ny][nx] && board[ny][nx] != 'x') {
              visited[ny][nx] = true;
              Location nextState = new Location(ny, nx, state.t);
              if (board[ny][nx] != '.') {
                int endIndex = locIndexMap.get(nextState);
                graph[startIndex][endIndex] = nextState.t;
              }
              bfs.offer(nextState);
            }
          }
        }
      }

      int[][] dp = new int[1 << locList.size()][locList.size()];
      for (int i = 0; i < dp.length; i++) {
        Arrays.fill(dp[i], 1_000_000_000);
      }
      dfs(dp, graph, 0, 1, 0);
      int min = Integer.MAX_VALUE;
      for (int i = 1; i < locList.size(); i++) {
        if (min > dp[dp.length - 1][i]) {
          min = dp[dp.length - 1][i];
        }
      }

      sb.append(min == 1_000_000_000 ? -1 : min).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  static void dfs(int[][] dp, int[][] graph, int node, int state, int weight) {
    for (int i = 1, bitmask = 2; i < graph.length; i++, bitmask <<= 1) {
      if (graph[node][i] > 0 && (state & bitmask) == 0) {
        int nextState = state | bitmask;
        int nextWeight = weight + graph[node][i];
        if (dp[nextState][i] >= nextWeight) {
          dp[nextState][i] = nextWeight;
          dfs(dp, graph, i, nextState, nextWeight);
        }
      }
    }

  }

  static class Location {
    int y;
    int x;
    int t;

    Location(int y, int x, int t) {
      this.y = y;
      this.x = x;
      this.t = t;
    }

    @Override
    public int hashCode() {
      return Objects.hash(y, x);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Location) {
        Location loc = (Location) obj;
        return loc.y == this.y && loc.x == this.x;
      }
      return false;
    }

    @Override
    public String toString() {
      return y + " " + x;
    }
  }
}