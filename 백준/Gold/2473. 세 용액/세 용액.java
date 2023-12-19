import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    int[] liquids = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      liquids[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(liquids);

    int[] selects = new int[3];
    long sum = Long.MAX_VALUE;
    for (int i = 0; i < N - 2; i++) {
      int start = i + 1;
      int end = N - 1;
      while (start < end) {
        long newSum = (long) liquids[i] + (long) liquids[start] + (long) liquids[end];
        if (sum > Math.abs(newSum)) {
          selects[0] = liquids[i];
          selects[1] = liquids[start];
          selects[2] = liquids[end];
          sum = Math.abs(newSum);
        }

        if (newSum < 0) {
          start++;
        } else if (newSum > 0) {
          end--;
        } else {
          break;
        }
      }
    }

    System.out.println(selects[0] + " " + selects[1] + " " + selects[2]);

    br.close();
  }
}