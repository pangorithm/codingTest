import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[N + 1][N + 1];
    for (int mid = 1; mid <= N; mid++) {
      int diff = 0, start = mid - diff, end = mid + diff;
      while (start > 0 && end <= N && arr[start] == arr[end]) {
        dp[start][end] = 1;
        diff++;
        start = mid - diff;
        end = mid + diff;
      }
      int l = mid, r = mid + 1;
      diff = 0;
      start = l - diff;
      end = r + diff;
      while (start > 0 && end <= N && arr[start] == arr[end]) {
        dp[start][end] = 1;
        diff++;
        start = l - diff;
        end = r + diff;
      }
    }

    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      sb.append(dp[start][end]).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}