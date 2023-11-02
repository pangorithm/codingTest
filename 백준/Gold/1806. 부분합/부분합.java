import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0;
    int end = 1;
    int sum = arr[start];
    int min = Integer.MAX_VALUE;
    while (end <= N) {
      if (start < end && S <= sum) {
        min = Math.min(end - start, min);
      }

      if (sum >= S) {
        sum -= arr[start];
        start++;
      } else {
        if (end < N) {
          sum += arr[end];
        }
        end++;
      }
    }

    System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    br.close();
  }
}