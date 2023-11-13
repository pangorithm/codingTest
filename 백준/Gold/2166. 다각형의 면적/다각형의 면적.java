import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    long[][] coordinates = new long[N + 1][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      coordinates[i][0] = Long.parseLong(st.nextToken());
      coordinates[i][1] = Long.parseLong(st.nextToken());
    }
    coordinates[N] = coordinates[0];

    long sum1 = 0;
    long sum2 = 0;
    for (int i = 0; i < N; i++) {
      sum1 += coordinates[i][0] * coordinates[i + 1][1];
      sum2 += coordinates[i][1] * coordinates[i + 1][0];
    }

    System.out.printf("%.1f", ((double) Math.abs(sum1 - sum2)) / 2d);
    br.close();
  }
}