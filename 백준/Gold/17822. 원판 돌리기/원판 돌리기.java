import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());

    int[][] board = new int[N + 1][M];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      for (int i = x; i <= N; i += x) {
        board[i] = rotate(board[i], d, k);
      }
      searchSameNum(board);
    }

    int sum = 0;
    for (int i = 1; i <= N; i++) {
      for (int j = 0; j < M; j++) {
        sum += board[i][j];
      }
      // System.out.println(Arrays.toString(board[i]));
    }

    System.out.println(sum);
    br.close();
  }

  static void searchSameNum(int[][] board) {
    boolean[][] visited = new boolean[N + 1][M];
    boolean hasSameNum = false;
    ArrayDeque<int[]> numStack = new ArrayDeque<>();
    int sum = 0;
    int count = 0;

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] > 0 && !visited[i][j]) {
          visited[i][j] = true;
          int num = board[i][j];
          Queue<int[]> bfs = new ArrayDeque<>();
          ArrayDeque<int[]> tempStack = new ArrayDeque<>();
          int[] initState = new int[] { i, j };
          bfs.offer(initState);
          tempStack.push(initState);

          while (bfs.size() > 0) {
            int[] state = bfs.poll();
            for (int[] m : moves) {
              int nextI = state[0] + m[0];
              int nextJ = (M + state[1] + m[1]) % M;
              if (nextI > 0 && nextI <= N && !visited[nextI][nextJ] && board[nextI][nextJ] == num) {
                visited[nextI][nextJ] = true;
                int[] nextState = new int[] { nextI, nextJ };
                bfs.offer(nextState);
                tempStack.push(nextState);
              }
            }
          }

          if (tempStack.size() > 1) {
            hasSameNum = true;
            while (tempStack.size() > 0) {
              int[] n = tempStack.pop();
              board[n[0]][n[1]] = 0;
            }
          } else if (!hasSameNum) {
            int[] n = tempStack.pop();
            numStack.push(n);
            sum += board[n[0]][n[1]];
            count++;
          }
        }
      }
    }

    if (!hasSameNum && count > 0) {
      int avg = sum / count;
      int rest = sum % count;
      while (numStack.size() > 0) {
        int[] n = numStack.pop();
        if (board[n[0]][n[1]] > avg) {
          board[n[0]][n[1]]--;
        } else if (board[n[0]][n[1]] < avg || (rest > 0 && board[n[0]][n[1]] == avg)) {
          board[n[0]][n[1]]++;
        }
      }
    }
  }

  static int[] rotate(int[] ling, int d, int k) {
    int[] rotatedLing = new int[M];
    if (d == 0) {
      for (int i = 0; i < M; i++) {
        rotatedLing[(i + k) % M] = ling[i];
      }
    } else {
      for (int i = 0; i < M; i++) {
        rotatedLing[(i + M - k) % M] = ling[i];
      }
    }
    return rotatedLing;
  }

}