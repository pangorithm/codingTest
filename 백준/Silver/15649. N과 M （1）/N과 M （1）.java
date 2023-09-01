import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    dfs(new StringBuilder(), new HashSet<>());

    System.out.println(sb);
    in.close();
  }

  static void dfs(StringBuilder str, HashSet<Integer> set) {
    if (set.size() == M) {
      sb.append(str).append("\n");
    } else {
      for (int i = 1; i <= N; i++) {
        if (!set.contains(i)) {
          HashSet<Integer> nextSet = new HashSet<>(set);
          nextSet.add(i);
          dfs(new StringBuilder(str).append(i).append(" "), nextSet);
        }
      }
    }
  }
}