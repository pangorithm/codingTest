import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    ArrayList<Integer> coinList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int coin = Integer.parseInt(br.readLine());
      if (coin <= k) {
        coinList.add(coin);
      }
    }

    int[] dp = new int[k + 1];
    Arrays.fill(dp, 100_000);
    for (int coin : coinList) {
      dp[coin] = 1;
    }
    for (int i = 1; i <= k; i++) {
      for (int coin : coinList) {
        if (i >= coin) {
          dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        }
      }
    }

    System.out.println(dp[k] >= 100_000 ? -1 : dp[k]);
    br.close();
  }
}