import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] nums;
  static int S;
  static int count;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    nums = new int[N];
    S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    count = 0;

    dfs(0, 0);

    System.out.print(count);
    in.close();
  }

  static void dfs(int sum, int startIndex) {
    while (startIndex < N) {
      int nextSum = sum + nums[startIndex];
      if (nextSum == S) {
        count++;
      }
      dfs(nextSum, ++startIndex);
    }
  }
}