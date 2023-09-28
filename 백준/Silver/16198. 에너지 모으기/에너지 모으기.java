import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int max;

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    StringTokenizer st = new StringTokenizer(in.readLine());
    ArrayList<Integer> marbles = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      marbles.add(Integer.parseInt(st.nextToken()));
    }
    max = Integer.MIN_VALUE;

    dfs(marbles, 0);

    System.out.println(max);
    in.close();
  }

  static void dfs(ArrayList<Integer> marbles, int energy) {
    if (energy > max) {
      max = energy;
    }
    int nextLength = marbles.size() - 1;
    for (int i = 1; i < nextLength; i++) {
      ArrayList<Integer> nextMarbles = new ArrayList<>(marbles);
      nextMarbles.remove(i);
      dfs(nextMarbles, energy + nextMarbles.get(i - 1) * nextMarbles.get(i));
    }
  }
}
