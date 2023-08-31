import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    int T = Integer.parseInt(in.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int maxYear = M * N;
      while (x <= maxYear && y <= maxYear) {
        if (x < y) {
          x += M;
        } else if (x > y) {
          y += N;
        } else if (x == y) {
          sb.append(x).append("\n");
          break;
        }
      }

      if (x > maxYear || y > maxYear) {
        sb.append(-1).append("\n");
      }
    }

    System.out.println(sb);
    in.close();
  }
}
