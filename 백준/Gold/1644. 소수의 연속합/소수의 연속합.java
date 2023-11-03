import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(0);
      return;
    } else if (N == 2) {
      System.out.println(1);
      return;
    }

    boolean[] isPN = new boolean[N + 1];
    ArrayList<Integer> PNList = new ArrayList<>();
    Arrays.fill(isPN, true);
    isPN[0] = false;
    isPN[1] = false;
    PNList.add(2);
    int num = 4;
    while (num <= N) {
      isPN[num] = false;
      num += 2;
    }
    for (int i = 3; i <= N; i += 2) {
      if (isPN[i]) {
        PNList.add(i);
        num = i << 1;
        while (num <= N) {
          isPN[num] = false;
          num += i;
        }
      }
    }

    int start = 0;
    int end = 1;
    int length = PNList.size();
    int sum = PNList.get(0);
    int count = 0;

    while (end <= length) {
      if (sum == N) {
        count++;
      }

      if (sum > N) {
        sum -= PNList.get(start);
        start++;
      } else {
        if (end < length) {
          sum += PNList.get(end);
        }
        end++;
      }
    }

    System.out.println(count);
    br.close();
  }
}