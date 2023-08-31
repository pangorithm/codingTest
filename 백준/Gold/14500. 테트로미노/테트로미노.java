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

    for (int ai = 0; ai < h; ai++) {
      for (int aj = 0; aj < w; aj++) {

        for (int bi = Math.max(0, ai - 1); bi < Math.min(h, ai + 2); bi++) {
          for (int bj = Math.max(0, aj - 1); bj < Math.min(w, aj + 2); bj++) {
            if ((ai == bi && aj == bj) || (Math.abs(bi - ai) + Math.abs(bj - aj) != 1)) {
              continue;
            }

            for (int ci = Math.max(0, ai - 2); ci < Math.min(h, ai + 3); ci++) {
              for (int cj = Math.max(0, aj - 2); cj < Math.min(w, aj + 3); cj++) {
                if ((ai == ci && aj == cj) || (bi == ci && bj == cj) || (Math.abs(ci - bi) + Math.abs(cj - bj) != 1)) {
                  continue;
                }

                for (int di = Math.max(0, ai - 3); di < Math.min(h, ai + 4); di++) {
                  for (int dj = Math.max(0, aj - 3); dj < Math.min(w, aj + 4); dj++) {
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
