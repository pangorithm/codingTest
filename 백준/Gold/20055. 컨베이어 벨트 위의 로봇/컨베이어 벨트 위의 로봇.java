import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int loadIndex = 0;
    int unloadIndex = N - 1;
    int[] rails = new int[N << 1];
    boolean[] robotOn = new boolean[N << 1];

    int zeroCount = 0;
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < rails.length; i++) {
      int rail = Integer.parseInt(st.nextToken());
      if (rail == 0) {
        zeroCount++;
        rail = -1;
      }
      rails[i] = rail;
    }

    int step = 0;
    while (zeroCount < K) {
      step++;

      // 1
      loadIndex = (loadIndex + rails.length - 1) % rails.length;
      unloadIndex = (unloadIndex + rails.length - 1) % rails.length;
      robotOn[unloadIndex] = false;

      int index;
      // 2
      for (int i = unloadIndex - 1 + rails.length; (index = i % rails.length) != loadIndex; i--) {
        if (robotOn[index] && !robotOn[(index + 1) % rails.length] && rails[(index + 1) % rails.length] > 0) {
          robotOn[(index + 1) % rails.length] = true;
          rails[(index + 1) % rails.length]--;
          if (rails[(index + 1) % rails.length] == 0) {
            zeroCount++;
            rails[(index + 1) % rails.length] = -1;
          }
          robotOn[index] = false;
        }
      }
      robotOn[unloadIndex] = false;

      // 3
      if (rails[loadIndex] > 0) {
        robotOn[loadIndex] = true;
        rails[loadIndex]--;
        if (rails[loadIndex] == 0) {
          zeroCount++;
          rails[loadIndex] = -1;
        }
      }
    }

    System.out.println(step);
    in.close();
  }
}
