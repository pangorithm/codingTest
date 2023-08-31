import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(in.readLine());

    int n = 1;
    int digit = 1;
    int count = 0;
    while (n * 10 <= N) {
      count += digit++ * (n * 9);
      n *= 10;
    }
    count += (N - n) * digit;
    count += digit;

    System.out.println(count);
    in.close();
  }
}
