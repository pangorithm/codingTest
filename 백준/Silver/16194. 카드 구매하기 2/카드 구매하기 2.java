import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(in.readLine());
    int[] p = new int[N + 1];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 1; i <= N; i++) {
      p[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < N; i++) {
      for (int j = i; j < N; j++) {
        if (i + j <= N) {
          if (p[i + j] > p[i] + p[j]) {
            p[i + j] = p[i] + p[j];
          }
        }
      }
    }

    System.out.println(p[N]);
    in.close();
  }
}