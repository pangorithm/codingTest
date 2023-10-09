import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[] cards;
  static int max;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    cards = new int[N];
    max = 0;
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(cards);
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          int sum = cards[i] + cards[j] + cards[k];
          if (sum <= M) {
            if (sum > max) {
              max = sum;
            }
          } else {
            break;
          }
        }
      }
    }

    System.out.println(max);
    in.close();
  }

}