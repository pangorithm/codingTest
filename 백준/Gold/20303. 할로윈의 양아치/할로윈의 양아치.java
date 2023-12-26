import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] candies = new int[N + 1];
    ArrayList<Integer>[] friendLists = new ArrayList[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      candies[i] = Integer.parseInt(st.nextToken());
      friendLists[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      friendLists[a].add(b);
      friendLists[b].add(a);
    }

    ArrayList<CandyGroup> candyGroupList = new ArrayList<>();
    boolean[] visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        Queue<Integer> bfs = new ArrayDeque<>();
        bfs.offer(i);
        int candySum = candies[i];
        int childrenCount = 1;
        while (!bfs.isEmpty()) {
          int state = bfs.poll();
          for (int next : friendLists[state]) {
            if (!visited[next]) {
              visited[next] = true;
              candySum += candies[next];
              childrenCount++;
              bfs.offer(next);
            }
          }
        }
        candyGroupList.add(new CandyGroup(childrenCount, candySum));
      }
    }

    int[] backpack = new int[K];
    for (CandyGroup candyGroup : candyGroupList) {
      for (int i = K - 1; i >= candyGroup.childrenCount; i--) {
        int sum = backpack[i - candyGroup.childrenCount] + candyGroup.candySum;
        if (sum > backpack[i]) {
          backpack[i] = sum;
        }
      }
    }

    System.out.println(backpack[K - 1]);
    br.close();
  }

  static class CandyGroup {
    int childrenCount;
    int candySum;

    CandyGroup(int childrenCount, int candySum) {
      this.childrenCount = childrenCount;
      this.candySum = candySum;
    }
  }
}