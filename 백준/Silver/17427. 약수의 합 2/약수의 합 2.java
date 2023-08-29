import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    long sum = 0;
    for(int i = 1; i <= n; i++){
      sum += i * (n / i);
    }
    System.out.println(sum);
    in.close();
  }
}