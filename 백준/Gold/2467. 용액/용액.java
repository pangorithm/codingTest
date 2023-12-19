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
    int start = 0;
    int end = N - 1;
    int alkali = liquids[start];
    int acid = liquids[end];
    int sum = Math.abs(alkali + acid);
    while (start < end) {
      int newSum = liquids[start] + liquids[end];
      if (sum > Math.abs(newSum)) {
        alkali = liquids[start];
        acid = liquids[end];
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

    System.out.println(alkali + " " + acid);

    br.close();
  }
}
