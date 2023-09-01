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

    dfs(new StringBuilder(), 0);

    System.out.println(sb);
    in.close();
  }

  static void dfs(StringBuilder str, int dept) {
    if (dept == M) {
      sb.append(str).append("\n");
    } else {
      for (int i = 1; i <= N; i++) {
        dfs(new StringBuilder(str).append(i).append(" "), dept + 1);
      }
    }
  }
}