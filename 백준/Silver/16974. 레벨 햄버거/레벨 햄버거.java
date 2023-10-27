import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static long[] dpStack;
  static long[] dpPatty;
  static long X;
  static long count;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    dpStack = new long[N + 1];
    dpStack[0] = 1;
    dpPatty = new long[N + 1];
    dpPatty[0] = 1;
    for (int i = 0; i < N; i++) {
      dpStack[i + 1] = dpStack[i] * 2 + 3;
      dpPatty[i + 1] = dpPatty[i] * 2 + 1;
    }
    X = Long.parseLong(st.nextToken());
    count = 0;

    burger(N);

    System.out.println(count);
    in.close();
  }

  static void burger(int level) {
    if (X > 0) {
      X--;
    } else {
      return;
    }

    if (X > 0) {
      if (X >= dpStack[level - 1]) {
        X -= dpStack[level - 1];
        count += dpPatty[level - 1];
      } else {
        burger(level - 1);
      }
    } else {
      return;
    }

    if (X > 0) {
      X--;
      count++;
    } else {
      return;
    }

    if (X > 0) {
      if (X >= dpStack[level - 1]) {
        X -= dpStack[level - 1];
        count += dpPatty[level - 1];
      } else {
        burger(level - 1);
      }
    } else {
      return;
    }

    if (X > 0) {
      X--;
    } else {
      return;
    }
  }
}