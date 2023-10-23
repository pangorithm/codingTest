import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] A = new int[N];
    st = new StringTokenizer(in.readLine());
    A[0] = Integer.parseInt(st.nextToken());
    for (int i = 1; i < N; i++) {
      A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
    }

    int count = 0;
    int pre = -1;
    int post = 0;
    while (pre <= post && post < N) {
      int sum;
      if (pre > -1) {
        sum = A[post] - A[pre];
      } else {
        sum = A[post];
      }

      if (sum == M) {
        count++;
        post++;
      } else if (sum < M) {
        post++;
      } else if (sum > M) {
        pre++;
      }
    }

    System.out.println(count);
    in.close();
  }
}