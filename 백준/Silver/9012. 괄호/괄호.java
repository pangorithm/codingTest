import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    for (int i = 0; i < n; i++) {
      if (solution(in.readLine())) {
        sb.append("YES").append("\n");
      } else {
        sb.append("NO").append("\n");
      }
    }

    System.out.println(sb);
    in.close();
  }

  static boolean solution(String s) {

    int count = 0;
    char[] carr = s.toCharArray();
    for (char ch : carr) {
      if (ch == '(') {
        count++;
      } else {
        count--;
      }
      if (count < 0) {
        return false;
      }
    }

    return count == 0 ? true : false;
  }
}