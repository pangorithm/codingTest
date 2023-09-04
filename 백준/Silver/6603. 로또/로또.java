import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int k;
  static int[] S;
  static boolean[] used;
  static int[] nums;

  public static void main(String[] args) throws IOException {
    String str;
    while (!(str = in.readLine()).equals("0")) {
      StringTokenizer st = new StringTokenizer(str);
      k = Integer.parseInt(st.nextToken());
      S = new int[k];
      used = new boolean[k];
      nums = new int[6];
      for (int i = 0; i < k; i++) {
        S[i] = Integer.parseInt(st.nextToken());
      }
      dfs(0, -1);
      sb.append("\n");
    }

    System.out.print(sb);
    in.close();
  }

  static void dfs(int dept, int beforeIndex) {
    if (dept == 6) {
      for (int i = 0; i < 6; i++) {
        sb.append(nums[i]).append(" ");
      }
      sb.append("\n");
    } else if (k - beforeIndex > 6 - dept) {
      for (int i = beforeIndex + 1; i < k; i++) {
        if (!used[i]) {
          used[i] = true;
          nums[dept] = S[i];
          dfs(dept + 1, i);
          used[i] = false;
        }
      }
    }
  }
}