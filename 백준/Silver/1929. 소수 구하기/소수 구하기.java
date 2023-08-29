import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    HashSet<Integer> notPrimeSet = new HashSet<>();
    notPrimeSet.add(1);
    for (int i = 2; i <= n; i++) {
      if (!notPrimeSet.contains(i)) {
        if (i >= m) {
          sb.append(i).append("\n");
        }
        for (int j = i << 1; j <= n; j += i) {
          notPrimeSet.add(j);
        }
      }
    }

    System.out.println(sb);
    in.close();
  }
}