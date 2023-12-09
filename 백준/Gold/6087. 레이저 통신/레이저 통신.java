import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] moves = { { 1, 0, 0 }, { 0, 1, 1 }, { -1, 0, 2 }, { 0, -1, 3 } };
  static final int MAX_VALUE = 10_000;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int W = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    char[][] board = new char[H][W];
    ArrayList<int[]> cList = new ArrayList<>();
    for (int i = 0; i < H; i++) {
      board[i] = br.readLine().toCharArray();
      for (int j = 0; j < W; j++) {
        if (board[i][j] == 'C') {
          cList.add(new int[] { i, j });
        }
      }
    }
    int[][][] visit = new int[H][W][4];
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        Arrays.fill(visit[i][j], MAX_VALUE);
      }
    }

    int[] start = cList.get(0);
    int[] end = cList.get(1);
    Queue<int[]> bfs = new ArrayDeque<>(); // {y, x, 방향, 사용한 거울 갯수}
    for (int dir = 0; dir < 4; dir++) {
      bfs.offer(new int[] { start[0], start[1], dir, 0 });
      visit[start[0]][start[1]][dir] = 0;
    }
    while (!bfs.isEmpty()) {
      int[] state = bfs.poll();

      for (int[] m : moves) {
        int ny = state[0] + m[0];
        int nx = state[1] + m[1];
        int nd = m[2];
        int nextMirrorCount = state[2] == m[2] ? state[3] : state[3] + 1;
        if (ny >= 0 && ny < H && nx >= 0 && nx < W
            && board[ny][nx] != '*' && visit[ny][nx][nd] > nextMirrorCount) {
          visit[ny][nx][nd] = nextMirrorCount;
          bfs.offer(new int[] { ny, nx, nd, nextMirrorCount });
        }
      }
    }

    int min = MAX_VALUE;
    for (int v : visit[end[0]][end[1]]) {
      min = Math.min(min, v);
    }

    System.out.println(min);
    br.close();
  }
}
