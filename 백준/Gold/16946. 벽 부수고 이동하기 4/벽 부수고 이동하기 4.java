import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] board = new int[N][M];
    boolean[][] visited = new boolean[N][M];
    int[][] areaIndex = new int[N][M];
    ArrayList<Integer> areaCount = new ArrayList<>();
    areaCount.add(0);

    for (int i = 0; i < N; i++) {
      char[] cs = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        board[i][j] = cs[j] - '0';
      }
    }

    int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int index = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && board[i][j] == 0) {
          int count = 0;
          ArrayDeque<int[]> searchStack = new ArrayDeque<>();
          searchStack.push(new int[] { i, j });
          visited[i][j] = true;
          while (!searchStack.isEmpty()) {
            int[] state = searchStack.pop();
            areaIndex[state[0]][state[1]] = index;
            count++;
            for (int[] m : moves) {
              int ny = state[0] + m[0];
              int nx = state[1] + m[1];
              if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && board[ny][nx] == 0) {
                visited[ny][nx] = true;
                searchStack.push(new int[] { ny, nx });
              }
            }
          }
          areaCount.add(count);
          index++;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] == 1) {
          HashSet<Integer> areaSet = new HashSet<>();
          for (int[] m : moves) {
            int ny = i + m[0];
            int nx = j + m[1];
            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
              areaSet.add(areaIndex[ny][nx]);
            }
          }
          for (int areaCouIndex : areaSet) {
            board[i][j] += areaCount.get(areaCouIndex);
          }
          board[i][j] %= 10;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
