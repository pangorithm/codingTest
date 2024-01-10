import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] A = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(br.readLine());
    }

    int answer = 0;
    for (int i = N; i > 0; i--) {
      if (K >= A[i]) {
        answer += K / A[i];
        K %= A[i];
      }
    }
    System.out.println(answer);

    br.close();
  }
}