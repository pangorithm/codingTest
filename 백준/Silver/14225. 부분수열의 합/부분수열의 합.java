import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  static int n;
  static int[] s;
  static HashSet<Integer> set;

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(in.readLine());
    s = new int[n];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      s[i] = Integer.parseInt(st.nextToken());
    }
    set = new HashSet<Integer>();

    dfs(0, 0);

    int num = 1;
    while (set.contains(num)) {
      num++;
    }
    System.out.println(num);
    in.close();
  }

  static void dfs(int index, int sum) {
    while (index < n) {
      int nextSum = sum + s[index];
      set.add(nextSum);
      dfs(++index, nextSum);
    }
  }
}