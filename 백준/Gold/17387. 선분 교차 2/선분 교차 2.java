import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    long[][] L1 = new long[][] { { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) },
        { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) } };
    st = new StringTokenizer(br.readLine());
    long[][] L2 = new long[][] { { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) },
        { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) } };

    System.out.println(checkCCW(new long[][] { L1[0], L1[1], L2[0], L2[1] }));
    br.close();
  }

  public static int checkCCW(long[][] p) {
    boolean is_result = false;
    int result = 0;
    int p123 = ccw(p[0], p[1], p[2]);
    int p124 = ccw(p[0], p[1], p[3]);
    int p341 = ccw(p[2], p[3], p[0]);
    int p342 = ccw(p[2], p[3], p[1]);

    boolean compare1 = Math.min(p[0][0], p[1][0]) <= Math.max(p[2][0], p[3][0]);
    boolean compare2 = Math.min(p[2][0], p[3][0]) <= Math.max(p[0][0], p[1][0]);
    boolean compare3 = Math.min(p[0][1], p[1][1]) <= Math.max(p[2][1], p[3][1]);
    boolean compare4 = Math.min(p[2][1], p[3][1]) <= Math.max(p[0][1], p[1][1]);

    if (p123 * p124 == 0 && p341 * p342 == 0) {
      is_result = true;
      if (compare1 && compare2 && compare3 && compare4)
        result = 1;
    }
    if (p123 * p124 <= 0 && p341 * p342 <= 0) {
      if (!is_result)
        result = 1;
    }
    return result;
  }

  public static int ccw(long[] p1, long[] p2, long[] p3) {
    // CCW 공식 (x1y2+x2y3+x3y1)−(y1x2+y2x3+y3x1)
    long result = ((p1[0] * p2[1]) + (p2[0] * p3[1]) + (p3[0] * p1[1]))
        - ((p1[1] * p2[0]) + (p2[1] * p3[0]) + (p3[1] * p1[0]));
    if (result > 0) // 반시계
      return 1;
    else if (result == 0) // 일직선
      return 0;
    else // 시계
      return -1;
  }
}