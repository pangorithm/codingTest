import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    ArrayList<Integer>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }
    int[] deptArr = new int[N + 1];

    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      graph[A].add(B);
      deptArr[B]++;
    }

    Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
      if (deptArr[a] == deptArr[b]) {
        return a - b;
      } else {
        return deptArr[a] - deptArr[b];
      }
    });

    for (int i = 1; i <= N; i++) {
      if (deptArr[i] == 0) {
        pq.offer(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      int A = pq.poll();
      for (int B : graph[A]) {
        deptArr[B]--;
        if (deptArr[B] == 0) {
          pq.offer(B);
        }
      }
      sb.append(A).append(" ");
    }

    System.out.println(sb);
    br.close();
  }
}
