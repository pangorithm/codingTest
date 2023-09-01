import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int N;
  static int M;
  static int[] numArr;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    numArr = new int[N];

    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
      numArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(numArr);

    dfs(new StringBuilder(), new HashSet<Integer>());

    System.out.println(sb);
    in.close();
  }

  static void dfs(StringBuilder str, HashSet<Integer> set) {
    if (set.size() == M) {
      sb.append(str).append("\n");
    } else {
      for (int num : numArr) {
        if (!set.contains(num)) {
          HashSet<Integer> nextSet = new HashSet<>(set);
          nextSet.add(num);
          dfs(new StringBuilder(str).append(num).append(" "), nextSet);
        }
      }
    }
  }
}
