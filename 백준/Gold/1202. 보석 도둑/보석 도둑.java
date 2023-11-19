import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    PriorityQueue<int[]> gemWeightPQ = new PriorityQueue<>((g1, g2) -> g1[0] - g2[0]); // 무게가 가벼운 순서
    PriorityQueue<int[]> gemValuePQ = new PriorityQueue<>((g1, g2) -> g2[1] - g1[1]); // 가치가 높은 순서
    PriorityQueue<Integer> bagPQ = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      gemWeightPQ.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
    }
    for (int i = 0; i < K; i++) {
      bagPQ.offer(Integer.parseInt(br.readLine()));
    }

    long sum = 0;

    while (bagPQ.size() > 0) {
      int bagSize = bagPQ.poll();
      while (gemWeightPQ.size() > 0 && gemWeightPQ.peek()[0] <= bagSize) {
        gemValuePQ.offer(gemWeightPQ.poll());
      }
      if (gemValuePQ.size() > 0) {
        sum += gemValuePQ.poll()[1];
      }
    }

    System.out.println(sum);
    br.close();
  }
}