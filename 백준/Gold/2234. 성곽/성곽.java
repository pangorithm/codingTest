import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int W = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    int[][] board = new int[H][W];

    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    ArrayList<Integer> roomSizeList = new ArrayList<>();
    int index = 0;
    int maxSize = 0;
    boolean[][] visited = new boolean[H][W];
    int[][] roomIndex = new int[H][W];
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (!visited[i][j]) {
          visited[i][j] = true;

          Queue<int[]> bfs = new ArrayDeque<>();
          bfs.offer(new int[] { i, j });
          int size = 0;
          while (!bfs.isEmpty()) {
            int[] state = bfs.poll();
            roomIndex[state[0]][state[1]] = index;
            size++;

            int wallState = board[state[0]][state[1]];
            int y = state[0];
            int x = state[1];
            if ((wallState & 1) == 0 && !visited[y][x - 1]) { // 서쪽에 벽이 없는 경우
              visited[y][x - 1] = true;
              bfs.offer(new int[] { y, x - 1 });
            }
            if ((wallState & 2) == 0 && !visited[y - 1][x]) { // 북쪽에 벽이 없는 경우
              visited[y - 1][x] = true;
              bfs.offer(new int[] { y - 1, x });
            }
            if ((wallState & 4) == 0 && !visited[y][x + 1]) { // 동쪽에 벽이 없는 경우
              visited[y][x + 1] = true;
              bfs.offer(new int[] { y, x + 1 });
            }
            if ((wallState & 8) == 0 && !visited[y + 1][x]) { // 남쪽에 벽이 없는 경우
              visited[y + 1][x] = true;
              bfs.offer(new int[] { y + 1, x });
            }
          }

          roomSizeList.add(size);
          index++;
          if (maxSize < size) {
            maxSize = size;
          }
        }
      }
    }

    int maxSizeSum = 0;
    // 가로벽을 삭제한 경우
    for (int i = 1; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (roomIndex[i - 1][j] != roomIndex[i][j]) {
          int sum = roomSizeList.get(roomIndex[i - 1][j]) + roomSizeList.get(roomIndex[i][j]);
          if (maxSizeSum < sum) {
            maxSizeSum = sum;
          }
        }
      }
    }

    // 세로벽을 삭제한 경우
    for (int i = 0; i < H; i++) {
      for (int j = 1; j < W; j++) {
        if (roomIndex[i][j - 1] != roomIndex[i][j]) {
          int sum = roomSizeList.get(roomIndex[i][j - 1]) + roomSizeList.get(roomIndex[i][j]);
          if (maxSizeSum < sum) {
            maxSizeSum = sum;
          }
        }
      }
    }

    System.out.println(new StringBuilder()
        .append(roomSizeList.size()).append("\n")
        .append(maxSize).append("\n")
        .append(maxSizeSum));
    br.close();
  }
}
