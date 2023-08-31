import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    int T = Integer.parseInt(in.readLine());
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(in.readLine());
      sb.append(search(n, 0)).append("\n");
    }

    System.out.println(sb);
    in.close();
  }

  private static int search(int n, int sum) {
    int count = 0;
    if (sum == n) {
      return 1;
    } else if (sum < n) {
      for (int i = 1; i < 4; i++) {
        count += search(n, sum + i);
      }
    }
    return count;
  }
}