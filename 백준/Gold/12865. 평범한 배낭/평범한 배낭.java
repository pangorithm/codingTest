import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int K;
  static int[][] itemArr;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    itemArr = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      itemArr[i][0] = Integer.parseInt(st.nextToken()); // 무게
      itemArr[i][1] = Integer.parseInt(st.nextToken()); // 가치
    }

    int[] dp = new int[K + 1];
    for (int i = 0; i < N; i++) {
      for (int w = K; w >= itemArr[i][0]; w--) {
        dp[w] = Math.max(dp[w], dp[w - itemArr[i][0]] + itemArr[i][1]);
      }
    }

    System.out.println(dp[K]);
    in.close();
  }

}
