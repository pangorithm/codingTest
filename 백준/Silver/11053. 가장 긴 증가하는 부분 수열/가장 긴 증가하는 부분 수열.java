import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int N = Integer.parseInt(in.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    int[] lia = new int[N];
    int liaLastIndex = 0;

    lia[0] = A[0];
    for (int i = 1; i < N; i++) {
      if (lia[liaLastIndex] < A[i]) {
        lia[++liaLastIndex] = A[i];
      } else {
        int start = 0;
        int end = liaLastIndex;
        int mid = (start + end) >> 1;
        while (start < end) {
          if (lia[mid] < A[i]) {
            start = mid + 1;
          } else if (lia[mid] > A[i]) {
            end = mid;
          } else {
            break;
          }
          mid = (start + end) >> 1;
        }
        lia[mid] = A[i];
      }
    }

    System.out.println(liaLastIndex + 1);
    in.close();
  }

}