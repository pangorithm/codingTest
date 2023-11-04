import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] aArr = new int[N >> 1];
    int[] bArr = new int[N - aArr.length];
    int S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < aArr.length; i++) {
      aArr[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < bArr.length; i++) {
      bArr[i] = Integer.parseInt(st.nextToken());
    }

    int[] a = new int[1 << aArr.length];
    int[] b = new int[1 << bArr.length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < aArr.length; j++) {
        if ((i & (1 << j)) != 0) {
          a[i] += aArr[j];
        }
      }
    }
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < bArr.length; j++) {
        if ((i & (1 << j)) != 0) {
          b[i] += bArr[j];
        }
      }
    }

    Arrays.sort(a);
    Arrays.sort(b);

    int aIndex = 0;
    int bIndex = b.length - 1;
    long count = S == 0 ? -1 : 0;

    while (aIndex < a.length && bIndex >= 0) {
      int sum = a[aIndex] + b[bIndex];
      if (sum == S) {
        long aCount = 0;
        long bCount = 0;
        int aValue = a[aIndex];
        int bValue = b[bIndex];
        while (aIndex < a.length && aValue == a[aIndex]) {
          aCount++;
          aIndex++;
        }
        while (bIndex >= 0 && bValue == b[bIndex]) {
          bCount++;
          bIndex--;
        }
        count += aCount * bCount;
      } else if (sum < S) {
        aIndex++;
      } else {
        bIndex--;
      }
    }

    System.out.println(count);
    in.close();
  }
}