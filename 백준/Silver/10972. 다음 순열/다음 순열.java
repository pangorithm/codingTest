import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] inputs;
  static int[] nums;
  static boolean finished;

  public static void main(String[] args) throws IOException {

    N = Integer.parseInt(in.readLine());
    StringTokenizer st = new StringTokenizer(in.readLine());
    inputs = new int[N];
    for (int i = 0; i < N; i++) {
      inputs[i] = Integer.parseInt(st.nextToken());
    }
    nums = new int[N];
    finished = false;

    dfs(new HashSet<>(), 0);

    System.out.println(sb.length() == 0 ? "-1" : sb);
    in.close();
  }

  static void dfs(HashSet<Integer> set, int dept) {
    if (dept == N) {
      if (valid()) {
        for (int i = 0; i < N; i++) {
          sb.append(nums[i]).append(" ");
        }
        sb.append("\n");
        finished = true;
      }
    } else {
      for (int i = dept == 0 ? inputs[dept] : (inputs[dept - 1] == nums[dept - 1] ? inputs[dept] : 1); i <= N; i++) {
        if (finished) {
          break;
        }
        if (!set.contains(i)) {
          nums[dept] = i;
          set.add(i);
          dfs(set, dept + 1);
          set.remove(i);
        }
      }
    }
  }

  static boolean valid() {
    for (int i = 0; i < N; i++) {
      if (inputs[i] < nums[i]) {
        return true;
      } else if (inputs[i] > nums[i]) {
        return false;
      }
    }
    return false;
  }
}