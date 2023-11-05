import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int T = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    A[0] = Integer.parseInt(st.nextToken());
    for (int i = 1; i < N; i++) {
      A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
    }
    ArrayList<Integer> aSumList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      aSumList.add(A[i]);
      for (int j = i + 1; j < N; j++) {
        aSumList.add(A[j] - A[i]);
      }
    }
    Collections.sort(aSumList);

    int M = Integer.parseInt(br.readLine());
    int[] B = new int[M];
    st = new StringTokenizer(br.readLine());
    B[0] = Integer.parseInt(st.nextToken());
    for (int i = 1; i < M; i++) {
      B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
    }
    ArrayList<Integer> bSumList = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      bSumList.add(B[i]);
      for (int j = i + 1; j < M; j++) {
        bSumList.add(B[j] - B[i]);
      }
    }
    Collections.sort(bSumList, (n1, n2) -> n2 - n1);

    int aIndex = 0;
    int aSize = aSumList.size();
    int bIndex = 0;
    int bSize = bSumList.size();
    long count = 0;
    while (aIndex < aSize && bIndex < bSize) {
      int sum = aSumList.get(aIndex) + bSumList.get(bIndex);
      if (sum == T) {
        long ac = 0;
        long bc = 0;
        int av = aSumList.get(aIndex);
        int bv = bSumList.get(bIndex);
        while (aIndex < aSize && av == aSumList.get(aIndex)) {
          ac++;
          aIndex++;
        }
        while (bIndex < bSize && bv == bSumList.get(bIndex)) {
          bc++;
          bIndex++;
        }
        count += ac * bc;
      } else if (sum < T) {
        aIndex++;
      } else {
        bIndex++;
      }
    }

    System.out.println(count);
    br.close();
  }
}