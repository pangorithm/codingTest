import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    int[][] inputs = new int[n][n];
    inputs[0][0] = Integer.parseInt(in.readLine());
    for (int i = 1; i < n; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      inputs[i][0] = inputs[i - 1][0] + Integer.parseInt(st.nextToken());
      for (int j = 1; j < i; j++) {
        inputs[i][j] = Math.max(inputs[i - 1][j - 1], inputs[i - 1][j]) + Integer.parseInt(st.nextToken());
      }
      inputs[i][i] = inputs[i - 1][i - 1] + Integer.parseInt(st.nextToken());
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      if (max < inputs[n - 1][i]) {
        max = inputs[n - 1][i];
      }
    }
    System.out.println(max);
    in.close();
  }
}