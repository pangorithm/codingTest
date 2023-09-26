import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;
  static int max;
  static int min;

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(in.readLine());
    arr = new int[n];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(in.readLine());
    int plus = Integer.parseInt(st.nextToken());
    int minus = Integer.parseInt(st.nextToken());
    int mut = Integer.parseInt(st.nextToken());
    int div = Integer.parseInt(st.nextToken());

    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;

    cmd(plus, minus, mut, div, 0, arr[0]);

    System.out.println(max + "\n" + min);
    in.close();
  }

  static void cmd(int plus, int minus, int mut, int div, int dept, int result) {
    if (dept + 1 == n) {
      if (result > max) {
        max = result;
      }
      if (result < min) {
        min = result;
      }
    } else {
      dept++;
      if (plus > 0) {
        cmd(plus - 1, minus, mut, div, dept, result + arr[dept]);
      }
      if (minus > 0) {
        cmd(plus, minus - 1, mut, div, dept, result - arr[dept]);
      }
      if (mut > 0) {
        cmd(plus, minus, mut - 1, div, dept, result * arr[dept]);
      }
      if (div > 0) {
        cmd(plus, minus, mut, div - 1, dept, result / arr[dept]);
      }
    }
  }
}