import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    System.out.println(getGCD(a, b));
    System.out.println(a * b / getGCD(a, b));

    in.close();
  }

  static int getGCD(int a, int b) {
    if (a < b) {
      int temp = a;
      a = b;
      b = temp;
    }

    if (b == 0) {
      return a;
    } else {
      return getGCD(b, a % b);
    }
  }
}