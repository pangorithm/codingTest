import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    final int SIZE = 1000001;
    int N = Integer.parseInt(br.readLine());
    int[] players = new int[N];
    boolean[] cards = new boolean[SIZE];
    int[] scores = new int[SIZE];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      players[i] = Integer.parseInt(st.nextToken());
      cards[players[i]] = true;
    }
    for (int i : players) {
      for (int j = i << 1; j < SIZE; j += i) {
        if (cards[j]) {
          scores[i]++;
          scores[j]--;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int player : players) {
      sb.append(scores[player]).append(' ');
    }
    System.out.println(sb);
    br.close();
  }
}
