import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    list.add(Integer.MIN_VALUE);
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (list.get(list.size() - 1) < num) {
        list.add(num);
      } else {
        int l = 1;
        int r = list.size() - 1;
        while (l < r) {
          int mid = (l + r) >> 1;
          if (list.get(mid) >= num) {
            r = mid;
          } else {
            l = mid + 1;
          }
        }
        list.set(r, num);
      }
    }

    System.out.println(list.size() - 1);
    br.close();
  }
}