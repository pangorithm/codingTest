import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int s = Integer.parseInt(in.readLine());
    boolean[][] dp = new boolean[s << 1][s << 1];

    Queue<Integer[]> bfs = new ArrayDeque<>();
    bfs.offer(new Integer[] { 1, 0, 0 }); // {화면, 클립보드, 시간}
    dp[1][0] = true;
    while (bfs.size() > 0) {
      Integer[] state = bfs.poll();
      int nextTime = state[2] + 1;

      int nextScreen;
      int nextClipBoard;

      if (state[0] != state[1]) {
        nextScreen = state[0];
        nextClipBoard = state[0];
        if (nextScreen == s) {
          System.out.println(nextTime);
          break;
        } else if (!dp[nextScreen][nextClipBoard]) {
          bfs.offer(new Integer[] { nextScreen, nextClipBoard, nextTime });
          dp[nextScreen][nextClipBoard] = true;
        }
      }

      if (state[0] + state[1] <= s) {
        nextScreen = state[0] + state[1];
        nextClipBoard = state[1];
        if (nextScreen == s) {
          System.out.println(nextTime);
          break;
        } else if (!dp[nextScreen][nextClipBoard]) {
          bfs.offer(new Integer[] { state[0] + state[1], state[1], nextTime });
          dp[nextScreen][nextClipBoard] = true;
        }
      }

      if (state[0] > 0) {
        nextScreen = state[0] - 1;
        nextClipBoard = state[1];
        if (nextScreen == s) {
          System.out.println(nextTime);
          break;
        } else if (!dp[nextScreen][nextClipBoard]) {
          bfs.offer(new Integer[] { state[0] - 1, state[1], nextTime });
          dp[nextScreen][nextClipBoard] = true;
        }
      }

    }

    in.close();
  }
}
