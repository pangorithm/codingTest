import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] apps = new int[N][2];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      apps[i][0] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      apps[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[10001];
    dp[0] = 0;
    for (int[] app : apps) {
      for (int c = 10000; c >= app[1]; c--) {
        int memory = dp[c - app[1]] + app[0];
        if (dp[c] < memory) {
          dp[c] = memory;
        }
      }
    }

    int cost = 0;
    for (int c = 0; c < dp.length; c++) {
      if (dp[c] >= M) {
        cost = c;
        break;
      }
    }

    System.out.println(cost);
    br.close();
  }
}
