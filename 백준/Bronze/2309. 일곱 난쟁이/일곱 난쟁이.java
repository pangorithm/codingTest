import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int[] input = new int[9];
    int sum = 0;
    for (int i = 0; i < 9; i++) {
      input[i] = Integer.parseInt(in.readLine());
      sum += input[i];
    }
    Arrays.sort(input);

    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (sum - (input[i] + input[j]) == 100) {
          for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
              answer.append(input[k]).append("\n");
            }
          }

          System.out.println(answer);
          in.close();
          return;
        }
      }
    }

  }
}