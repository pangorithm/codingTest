import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    boolean[][] visit = new boolean[2000][2000];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    br.close();

    int sum = A + B + C;
    if (sum % 3 != 0) {
      System.out.println(0);
      return;
    }
    int avg = sum / 3;

    int[] initState = new int[] { A, B, C };
    Arrays.sort(initState);
    Queue<int[]> bfs = new ArrayDeque<>();
    visit[initState[0]][initState[1]] = true;
    if (initState[0] != avg || initState[1] != avg || initState[2] != avg) {
      bfs.offer(initState);
    }
    loop: while (bfs.size() > 0) {
      int[] state = bfs.poll();
      for (int i = 0; i < 3; i++) {
        for (int j = i + 1; j < 3; j++) {
          if (state[i] != state[j]) {
            int k = 3 - i - j;
            int[] nextState = new int[3];
            nextState[i] = state[i] << 1;
            nextState[j] = state[j] - state[i];
            nextState[k] = state[k];
            Arrays.sort(nextState);
            if (!visit[nextState[0]][nextState[1]]) {
              visit[nextState[0]][nextState[1]] = true;
              bfs.offer(nextState);
            }
          }
        }
      }
    }

    System.out.println(visit[avg][avg] ? 1 : 0);
  }
}