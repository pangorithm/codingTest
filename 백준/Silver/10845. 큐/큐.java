import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      switch (st.nextToken()) {
        case "push":
          dq.offer(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          sb.append(dq.isEmpty() ? "-1" : dq.poll()).append("\n");
          break;
        case "size":
          sb.append(dq.size()).append("\n");
          break;
        case "empty":
          sb.append(dq.isEmpty() ? "1" : "0").append("\n");
          break;
        case "front":
          sb.append(dq.isEmpty() ? "-1" : dq.peekFirst()).append("\n");
          break;
        case "back":
          sb.append(dq.isEmpty() ? "-1" : dq.peekLast()).append("\n");
          break;
      }
    }

    System.out.println(sb);
    in.close();
  }
}