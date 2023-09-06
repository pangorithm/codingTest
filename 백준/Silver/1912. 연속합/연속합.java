import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    int[] inputs = new int[n];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      inputs[i] = Integer.parseInt(st.nextToken());
    }

    int max = inputs[0];
    for (int i = 1; i < n; i++) {
      int sum = inputs[i - 1] + inputs[i];
      if (inputs[i] < sum) {
        inputs[i] = sum;
      }
      if (max < inputs[i]) {
        max = inputs[i];
      }
    }

    System.out.println(max);
    in.close();
  }
}
