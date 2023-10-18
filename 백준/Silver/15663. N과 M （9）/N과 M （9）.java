import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int N;
  static int M;
  static int[] numArr;
  static HashSet<String> strSet;

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
    strSet = new HashSet<>();
    dfs(new StringBuilder(), 0, 0);

    System.out.println(sb);
    in.close();
  }

  static void dfs(StringBuilder strBd, int dept, int flag) {
    if (dept == M) {
      String str = strBd.toString();
      if (!strSet.contains(str)) {
        sb.append(str).append("\n");
        strSet.add(str);
      }
    } else {
      int digit = 1;
      for (int i = 0; i < N; i++) {
        if ((flag & digit) == 0) {
          dfs(new StringBuilder(strBd).append(numArr[i]).append(" "), dept + 1, flag | digit);
        }
        digit <<= 1;
      }
    }
  }
}
