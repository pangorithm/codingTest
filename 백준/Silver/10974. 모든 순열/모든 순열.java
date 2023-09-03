import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] nums;

  public static void main(String[] args) throws IOException {

    N = Integer.parseInt(in.readLine());
    nums = new int[N];

    dfs(new HashSet<>(), 0);

    System.out.println(sb.length() == 0 ? "-1" : sb);
    in.close();
  }

  static void dfs(HashSet<Integer> set, int dept) {
    if (dept == N) {
      for (int i = 0; i < N; i++) {
        sb.append(nums[i]).append(" ");
      }
      sb.append("\n");
    } else {
      for (int i = 1; i <= N; i++) {
        if (!set.contains(i)) {
          nums[dept] = i;
          set.add(i);
          dfs(set, dept + 1);
          set.remove(i);
        }
      }
    }
  }
}