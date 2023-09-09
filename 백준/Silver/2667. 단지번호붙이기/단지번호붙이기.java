import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(in.readLine());
    char[][] board = new char[n + 2][n + 2];
    for (int i = 1; i <= n; i++) {
      char[] chars = in.readLine().toCharArray();
      for (int j = 0; j < n; j++) {
        board[i][j + 1] = chars[j];
      }
    }

    int apartmentCount = 0;
    ArrayList<Integer> houseCountList = new ArrayList<>();
    int[] moves = { -1, 1 };
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (board[i][j] == '1') {
          apartmentCount++;

          Queue<Integer[]> bfs = new ArrayDeque<>();
          bfs.offer(new Integer[] { i, j });
          board[i][j] = '0';
          int houseCount = 1;

          while (bfs.size() > 0) {
            Integer[] state = bfs.poll();
            for (int m : moves) {
              int nextY = state[0] + m;
              int nextX = state[1] + m;
              if (board[state[0]][nextX] == '1') {
                bfs.offer(new Integer[] { state[0], nextX });
                board[state[0]][nextX] = '0';
                houseCount++;
              }
              if (board[nextY][state[1]] == '1') {
                bfs.offer(new Integer[] { nextY, state[1] });
                board[nextY][state[1]] = '0';
                houseCount++;
              }
            }
          }

          houseCountList.add(houseCount);
        }
      }
    }

    sb.append(apartmentCount).append("\n");
    Collections.sort(houseCountList);
    for (int houseCount : houseCountList) {
      sb.append(houseCount).append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}
