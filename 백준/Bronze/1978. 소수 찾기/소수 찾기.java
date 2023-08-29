import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    StringTokenizer st = new StringTokenizer(in.readLine());
    int[] input = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(st.nextToken());
      if (max < input[i]) {
        max = input[i];
      }
    }

    HashSet<Integer> notPrimeSet = new HashSet<>();
    notPrimeSet.add(1);
    for (int i = 2; i <= max; i++) {
      if (!notPrimeSet.contains(i)) {
        for (int j = i << 1; j <= max; j += i) {
          notPrimeSet.add(j);
        }
      }
    }

    int answer = 0;
    for (int x : input) {
      if (!notPrimeSet.contains(x)) {
        answer++;
      }
    }

    System.out.println(answer);
    in.close();
  }
}
