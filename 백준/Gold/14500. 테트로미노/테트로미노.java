import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int[][] board;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(in.readLine());
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    board = new int[h][w];
    for (int i = 0; i < h; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < w; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int max = 0;

    int maxI;
    int maxJ;
    for (int ai = 0; ai < h; ai++) {
      for (int aj = 0; aj < w; aj++) {
        maxI = Math.min(h, ai + 2);
        maxJ = Math.min(w, aj + 2);
        for (int bi = ai; bi < maxI; bi++) {
          for (int bj = Math.max(0, aj - 1); bj < maxJ; bj++) {
            if ((ai == bi && aj == bj) || (Math.abs(bi - ai) + Math.abs(bj - aj) != 1)) {
              continue;
            }
            maxI = Math.min(h, ai + 3);
            maxJ = Math.min(w, aj + 3);
            for (int ci = ai; ci < maxI; ci++) {
              for (int cj = Math.max(0, aj - 2); cj < maxJ; cj++) {
                if ((ai == ci && aj == cj) || (bi == ci && bj == cj) || (Math.abs(ci - bi) + Math.abs(cj - bj) != 1)) {
                  continue;
                }
                maxI = Math.min(h, ai + 4);
                maxJ = Math.min(w, aj + 4);
                for (int di = ai; di < maxI; di++) {
                  for (int dj = Math.max(0, aj - 2); dj < maxJ; dj++) {
                    if ((ai == di && aj == dj) || (bi == di && bj == dj) || (ci == di && cj == dj)
                        || ((Math.abs(di - bi) + Math.abs(dj - bj) != 1)
                            && (Math.abs(di - ci) + Math.abs(dj - cj) != 1))) {
                      continue;
                    }
                    int sum = board[ai][aj] + board[bi][bj] + board[ci][cj] + board[di][dj];
                    if (max < sum) {
                      max = sum;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    System.out.println(max);
    in.close();
  }
}
