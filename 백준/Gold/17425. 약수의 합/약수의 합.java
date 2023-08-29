import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();

    long[] sum = new long[1000001];

    for (int i = 1; i <= 1000000; i++) {
      for (int j = i; j <= 1000000; j += i) {
        sum[j] += i;
      }
    }

    for (int i = 1; i <= 1000000; i++) {
      sum[i] += sum[i - 1];
    }

    int n = Integer.parseInt(in.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(in.readLine());
      sb.append(sum[x]).append("\n");
    }

    System.out.print(sb);
    in.close();
  }
}