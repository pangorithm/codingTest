import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    HashSet<Integer> aSet = new HashSet<>();
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      aSet.add(Integer.parseInt(st.nextToken()));
    }
    int m = Integer.parseInt(in.readLine());
    st = new StringTokenizer(in.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      if (aSet.contains(Integer.parseInt(st.nextToken()))) {
        sb.append('1').append("\n");
      } else {
        sb.append('0').append("\n");
      }
    }

    System.out.println(sb);
    in.close();
  }
}