import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[][] meetings = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      meetings[i][0] = Integer.parseInt(st.nextToken());
      meetings[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(meetings, (m1, m2) -> {
      if (m1[1] == m2[1]) {
        return m1[0] - m2[0];
      } else {
        return m1[1] - m2[1];
      }
    });

    int count = 0;
    int endTime = 0;
    for (int[] meeting : meetings) {
      if (meeting[0] >= endTime) {
        count++;
        endTime = meeting[1];
      }
    }

    System.out.println(count);
    br.close();
  }
}