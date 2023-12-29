import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] parent;

  public static void main(String[] args) throws IOException {

    int G = Integer.parseInt(br.readLine());
    int P = Integer.parseInt(br.readLine());
    parent = new int[G + 1];

    for (int i = 1; i <= G; i++) {
      parent[i] = i;
    }

    int count = 0;
    for (int p = 0; p < P; p++) {
      int gate = Integer.parseInt(br.readLine());
      int rootGate = search(gate);
      if (rootGate == 0) {
        break;
      } else {
        count++;
        union(rootGate, rootGate - 1);
      }
    }

    System.out.println(count);
    br.close();
  }

  static int search(int i) {
    if (i == parent[i]) {
      return i;
    } else {
      return parent[i] = search(parent[i]);
    }
  }

  static boolean union(int a, int b) {
    int rootA = search(a);
    int rootB = search(b);

    if (rootA == rootB) {
      return false;
    } else {
      parent[rootA] = rootB;
      return true;
    }
  }

}
