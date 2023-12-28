import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static long[] dp = new long[55];

  public static void main(String[] args) throws IOException {

    dp[0] = 1;
    for (int i = 1; i < 55; i++) {
      dp[i] = (dp[i - 1] << 1) + (1l << i);
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    System.out.println(countOne(B) - countOne(A - 1));
    br.close();
  }

  static long countOne(long num) {
    long count = num & 1;
    int size = (int) (Math.log(num) / Math.log(2));
    for (int i = size; i > 0; i--) {
      long bitmask = 1l << i;
      if ((num & bitmask) != 0l) {
        count += dp[i - 1] + (num - bitmask + 1);
        num -= bitmask;
      }
    }

    return count;
  }
}