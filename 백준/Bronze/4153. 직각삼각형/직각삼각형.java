import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    String str;
    while (!(str = in.readLine()).equals("0 0 0")) {
      StringTokenizer st = new StringTokenizer(str);
      int[] sides = new int[3];
      sides[0] = Integer.parseInt(st.nextToken());
      sides[1] = Integer.parseInt(st.nextToken());
      sides[2] = Integer.parseInt(st.nextToken());
      Arrays.sort(sides);

      if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) {
        sb.append("right").append("\n");
      } else {
        sb.append("wrong").append("\n");
      }
    }

    System.out.println(sb);
    in.close();
  }
}
