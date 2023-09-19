import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();
    String str;
    loop: while (!(str = in.readLine()).equals("0")) {
      int num = Integer.parseInt(str);
      ArrayDeque dq = new ArrayDeque<Integer>();
      while (num > 0) {
        dq.offer(num % 10);
        num /= 10;
      }

      while (dq.size() > 0) {
        if (dq.peekFirst() != dq.peekLast()) {
          sb.append("no").append("\n");
          continue loop;
        } else {
          dq.pollFirst();
          if (dq.size() > 0) {
            dq.pollLast();
          }
        }
      }
      sb.append("yes").append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}