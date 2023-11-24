import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static boolean[] isPrime = new boolean[10000];
  static int[] dp = new int[10000];

  public static void main(String[] args) throws IOException {

    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;
    for (int i = 4; i < 10000; i += 2) {
      isPrime[i] = false;
    }
    for (int i = 3; i < 10000; i += 2) {
      if (isPrime[i]) {
        int num = i << 1;
        while (num < 10000) {
          isPrime[num] = false;
          num += i;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      Arrays.fill(dp, Integer.MAX_VALUE);
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      String printWord = "Impossible";

      Queue<int[]> bfs = new ArrayDeque<>();
      if (from == to) {
        printWord = "0";
      } else {
        bfs.offer(new int[] { from, 0 }); // {소수, 변환 횟수}
      }
      loop: while (bfs.size() > 0) {
        int[] state = bfs.poll();
        state[1]++;
        String num = Integer.toString(state[0]);
        char[] chars = num.toCharArray();
        for (int i = 0; i < 4; i++) {
          chars[i] -= '0';
        }
        for (int i = 1; i <= 9; i++) {
          if (i != chars[0]) {
            int nextNum = Integer.parseInt(
                new StringBuilder()
                    .append(i)
                    .append(num.substring(1, 4))
                    .toString());
            if (isPrime[nextNum]) {
              if (nextNum == to) {
                printWord = Integer.toString(state[1]);
                break loop;
              } else {
                if (dp[nextNum] > state[1]) {
                  bfs.offer(new int[] { nextNum, state[1] });
                  dp[nextNum] = state[1];
                }
              }
            }
          }
        }
        for (int i = 1; i < 4; i++) {
          for (int j = 0; j <= 9; j++) {
            if (j != chars[i]) {
              int nextNum = Integer.parseInt(
                  new StringBuilder()
                      .append(num.substring(0, i))
                      .append(j)
                      .append(num.substring(i + 1, 4))
                      .toString());
              if (isPrime[nextNum]) {
                if (nextNum == to) {
                  printWord = Integer.toString(state[1]);
                  break loop;
                } else {
                  if (dp[nextNum] > state[1]) {
                    bfs.offer(new int[] { nextNum, state[1] });
                    dp[nextNum] = state[1];
                  }
                }
              }
            }
          }
        }
      }
      sb.append(printWord).append("\n");

    }

    System.out.println(sb);
    br.close();
  }
}