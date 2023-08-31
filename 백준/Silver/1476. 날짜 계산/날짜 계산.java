import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int E = Integer.parseInt(st.nextToken());
    E = E == 15 ? 0 : E;
    int S = Integer.parseInt(st.nextToken());
    S = S == 28 ? 0 : S;
    int M = Integer.parseInt(st.nextToken());
    M = M == 19 ? 0 : M;

    int year = 1;
    while (year % 15 != E || year % 28 != S || year % 19 != M) {
      year++;
    }

    System.out.println(year);
    in.close();
  }
}