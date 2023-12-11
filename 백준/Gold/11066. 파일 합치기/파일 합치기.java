import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int K = Integer.parseInt(br.readLine());
      int[][] costBoard = new int[K][K];
      for (int i = 0; i < K; i++) {
        Arrays.fill(costBoard[i], Integer.MAX_VALUE);
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] cumSum = new int[K];
      costBoard[0][0] = 0;
      cumSum[0] = Integer.parseInt(st.nextToken());
      for (int k = 1; k < K; k++) {
        costBoard[k][k] = 0;
        cumSum[k] = cumSum[k - 1] + Integer.parseInt(st.nextToken());

      }

      for (int addSize = 1; addSize < K; addSize++) {
        for (int start = 0, end = start + addSize; end < K; start++, end = start + addSize) {
          for (int mid = start + 1; mid <= end; mid++) {
            int sum = costBoard[start][mid - 1] + costBoard[mid][end]
                + (start == 0 ? cumSum[end] : (cumSum[end] - cumSum[start - 1]));
            if (costBoard[start][end] > sum) {
              costBoard[start][end] = sum;
            }
          }
        }
      }

      sb.append(costBoard[0][K - 1]).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}