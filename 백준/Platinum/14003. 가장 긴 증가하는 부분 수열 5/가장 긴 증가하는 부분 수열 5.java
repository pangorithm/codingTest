import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    ArrayList<Integer> list = new ArrayList<>();
    list.add(Integer.MIN_VALUE);
    int[] listIndex = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      A[i] = num;

      if (list.get(list.size() - 1) < num) {
        listIndex[i] = list.size();
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
        listIndex[i] = r;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(list.size() - 1 + "\n");
    Stack<Integer> stack = new Stack();

    int index = list.size() - 1;
    for (int i = N - 1; i >= 0; i--) {
      if (listIndex[i] == index) {
        index--;
        stack.push(A[i]);
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop() + " ");
    }
    System.out.println(sb);
    br.close();
  }
}