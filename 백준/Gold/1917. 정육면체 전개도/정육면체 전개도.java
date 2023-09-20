import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;
    for (int boardCount = 0; boardCount < 3; boardCount++) {
      int[][] board = new int[6][6];
      for (int yCount = 0; yCount < 6; yCount++) {
        st = new StringTokenizer(in.readLine());
        for (int xCount = 0; xCount < 6; xCount++) {
          board[yCount][xCount] = Integer.parseInt(st.nextToken());
        }
      }

      if (valid(board)) {
        sb.append("yes").append("\n");
      } else {
        sb.append("no").append("\n");
      }
    }

    System.out.println(sb);
    in.close();
  }

  static boolean valid(int[][] board) {

    int[] iCount = new int[6];
    int[] jCount = new int[6];
    int[] iRange = { 6, -1 };
    int[] jRange = { 6, -1 };
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (board[i][j] == 1) {
          iCount[i]++;
          jCount[j]++;

          if (i < iRange[0]) {
            iRange[0] = i;
          } else if (i > iRange[1]) {
            iRange[1] = i;
          }
          if (j < jRange[0]) {
            jRange[0] = j;
          } else if (j > jRange[1]) {
            jRange[1] = j;
          }
        }
      }
    }

    int iLength = iRange[1] - iRange[0] + 1;
    int jLength = jRange[1] - jRange[0] + 1;

    if (iLength + jLength == 7 && iLength != 1 && jLength != 1) {
      for (int k = 0; k < 4; k++) {
        if (iCount[k] == 1 && iCount[k + 1] == 4 && iCount[k + 2] == 1) {
          return true;
        }
        if (jCount[k] == 1 && jCount[k + 1] == 4 && jCount[k + 2] == 1) {
          return true;
        }

        if (iCount[k] == 1 && iCount[k + 1] == 3 && iCount[k + 2] == 2) {
          return true;
        }
        if (jCount[k] == 1 && jCount[k + 1] == 3 && jCount[k + 2] == 2) {
          return true;
        }
        if (iCount[k] == 2 && iCount[k + 1] == 3 && iCount[k + 2] == 1) {
          return true;
        }
        if (jCount[k] == 2 && jCount[k + 1] == 3 && jCount[k + 2] == 1) {
          return true;
        }

        if (iCount[k] == 2 && iCount[k + 1] == 2 && iCount[k + 2] == 2) {
          return true;
        }
        if (jCount[k] == 2 && jCount[k + 1] == 2 && jCount[k + 2] == 2) {
          return true;
        }

        if ((iCount[k] == 3 || iCount[k + 2] == 3) && iCount[k + 1] == 3) {
          return true;
        }
        if ((jCount[k] == 3 || jCount[k + 2] == 3) && jCount[k + 1] == 3) {
          return true;
        }
      }
    }

    return false;
  }
}