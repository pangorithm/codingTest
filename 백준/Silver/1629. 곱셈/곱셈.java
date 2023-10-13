import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int c;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    long a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    System.out.println(pow(a, b));
    in.close();
  }

  public static long pow(long a, long exp) {

    if (exp == 1) {
      return a % c;
    }

    long temp = pow(a, exp >> 1);

    if ((exp & 1) == 1) {
      return (temp * temp % c) * a % c;
    }
    return temp * temp % c;

  }
}
