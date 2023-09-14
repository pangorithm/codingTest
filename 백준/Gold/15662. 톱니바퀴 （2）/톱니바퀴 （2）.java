import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int T;
  static int[] gears;
  static int K;
  static int[][] cmds;

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(in.readLine());
    gears = new int[T + 1];
    for (int i = 1; i <= T; i++) {
      gears[i] = Integer.parseInt(in.readLine(), 2);
    }

    K = Integer.parseInt(in.readLine());
    cmds = new int[K][2];
    for (int i = 0; i < K; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      cmds[i][0] = Integer.parseInt(st.nextToken());
      cmds[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int cc = 0; cc < K; cc++) {
      int start = cmds[cc][0];
      int end = cmds[cc][0];
      for (int i = cmds[cc][0]; i > 1; i--) {
        if (checkMoveable(gears[i - 1], gears[i])) {
          start = i - 1;
        } else {
          break;
        }
      }
      for (int i = cmds[cc][0]; i < T; i++) {
        if (checkMoveable(gears[i], gears[i + 1])) {
          end = i + 1;
        } else {
          break;
        }
      }

      if (cmds[cc][1] == 1) {
        for (int i = start; i <= end; i++) {
          if ((i & 1) == (cmds[cc][0] & 1)) {
            gears[i] = rotateCW(gears[i]);
          } else {
            gears[i] = rotateRCW(gears[i]);
          }
        }
      } else {
        for (int i = start; i <= end; i++) {
          if ((i & 1) == (cmds[cc][0] & 1)) {
            gears[i] = rotateRCW(gears[i]);
          } else {
            gears[i] = rotateCW(gears[i]);
          }
        }
      }
    }

    int count = 0;
    for (int i = 1; i <= T; i++) {
      if ((gears[i] & 128) == 128) {
        count++;
      }
    }

    System.out.println(count);
    in.close();
  }

  static boolean checkMoveable(int leftGear, int rightGear) {
    if ((leftGear & 32) >> 4 == (rightGear & 2)) {
      return false;
    }
    return true;
  }

  static int rotateCW(int gear) {
    if ((gear & 1) == 1) {
      gear = (gear >> 1) | 128;
    } else {
      gear >>= 1;
    }
    return gear;
  }

  static int rotateRCW(int gear) {
    if ((gear & 128) == 128) {
      gear = ((gear & 127) << 1) | 1;
    } else {
      gear <<= 1;
    }
    return gear;
  }
}
