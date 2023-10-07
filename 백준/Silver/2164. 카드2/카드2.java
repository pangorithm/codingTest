import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      dq.offerLast(i);
    }
    while (dq.size() != 1) {
      dq.pollFirst();
      dq.offerLast(dq.pollFirst());
    }

    System.out.println(dq.poll());
    in.close();
  }
}