import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] A;
  static int[] nums;
  static int max;

  public static void main(String[] args) throws IOException {

    N = Integer.parseInt(in.readLine());
    A = new int[N];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    nums = new int[N];
    max = 0;

    dfs(new HashSet<>(), 0);

    System.out.println(max);
    in.close();
  }

  static void dfs(HashSet<Integer> set, int dept) {
    if (dept == N) {
      int sum = f();
      if (max < sum) {
        max = sum;
      }
    } else {
      for (int i = 0; i < N; i++) {
        if (!set.contains(i)) {
          nums[dept] = i;
          set.add(i);
          dfs(set, dept + 1);
          set.remove(i);
        }
      }
    }
  }

  static int f() {
    int sum = 0;
    for (int i = 1; i < N; i++) {
      sum += Math.abs(A[nums[i]] - A[nums[i - 1]]);
    }
    return sum;
  }
}