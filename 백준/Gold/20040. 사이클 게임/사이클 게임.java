import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] parents;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    parents = new int[N];
    for (int i = 0; i < N; i++) {
      parents[i] = i;
    }

    int answer = 0;
    for (int turn = 1; turn <= M; turn++) {
      st = new StringTokenizer(br.readLine());
      if (answer > 0) {
        continue;
      }
      if (!union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
        answer = turn;
      }
    }

    System.out.println(answer);
    br.close();
  }

  static int find(int dot) {
    if (dot == parents[dot]) {
      return dot;
    } else {
      return parents[dot] = find(parents[dot]);
    }
  }

  static boolean union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);

    if (aRoot == bRoot) {
      return false;
    } else {
      parents[aRoot] = bRoot;
      return true;
    }
  }

}
