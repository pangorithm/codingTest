import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    boolean[] notPrimeArr = new boolean[1000_001]; // false일 경우 소수
    for (int i = 3; i <= 1000; i += 2) {
      if (!notPrimeArr[i]) {
        for (int j = i << 1; j <= 100_0000; j += i) {
          notPrimeArr[j] = true;
        }
      }
    }

    int n;
    loop: while ((n = Integer.parseInt(in.readLine())) != 0) {
      for (int i = 3; i <= 50_0000; i += 2) {
        if (!notPrimeArr[i] && !notPrimeArr[n - i]) {
          sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
          continue loop;
        }
      }
      sb.append("Goldbach's conjecture is wrong.");
    }

    System.out.println(sb);
    in.close();
  }
}