import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] board = new int[R + 1][C + 1];

    int[][] sharks = new int[M + 1][5]; // { r, c, s, d, z }
    HashSet<Integer> sharkSet = new HashSet<>();
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      board[r][c] = i;
      sharks[i][0] = r;
      sharks[i][1] = c;
      sharks[i][2] = Integer.parseInt(st.nextToken());
      sharks[i][3] = Integer.parseInt(st.nextToken());
      sharks[i][4] = Integer.parseInt(st.nextToken());
      sharkSet.add(i);
    }

    int sum = 0;
    int recallR = R * 2 - 2;
    int recallC = C * 2 - 2;
    for (int c = 1; c <= C; c++) {
      for (int r = 1; r <= R; r++) {
        int shark = board[r][c];
        if (shark > 0) {
          sum += sharks[shark][4];
          sharkSet.remove(shark);
          break;
        }
      }

      int[][] nextBoard = new int[R + 1][C + 1];
      HashSet<Integer> removeSharkSet = new HashSet<>();
      for (int shark : sharkSet) {
        board[sharks[shark][0]][sharks[shark][1]] = 0;
        switch (sharks[shark][3]) {
          case 1:
            int m = sharks[shark][2] % recallR;
            sharks[shark][0] -= m;
            if (sharks[shark][0] <= 0) {
              sharks[shark][0] = 2 - sharks[shark][0];
              sharks[shark][3] = 2;
              if (sharks[shark][0] > R) {
                sharks[shark][0] = R * 2 - sharks[shark][0];
                sharks[shark][3] = 1;
              }
            }
            break;
          case 2:
            m = sharks[shark][2] % recallR;
            sharks[shark][0] += m;
            if (sharks[shark][0] > R) {
              sharks[shark][0] = R * 2 - sharks[shark][0];
              sharks[shark][3] = 1;
              if (sharks[shark][0] <= 0) {
                sharks[shark][0] = 2 - sharks[shark][0];
                sharks[shark][3] = 2;
              }
            }
            break;
          case 3:
            m = sharks[shark][2] % recallC;
            sharks[shark][1] += m;
            if (sharks[shark][1] > C) {
              sharks[shark][1] = C * 2 - sharks[shark][1];
              sharks[shark][3] = 4;
              if (sharks[shark][1] <= 0) {
                sharks[shark][1] = 2 - sharks[shark][1];
                sharks[shark][3] = 3;
              }
            }
            break;
          case 4:
            m = sharks[shark][2] % recallC;
            sharks[shark][1] -= m;
            if (sharks[shark][1] <= 0) {
              sharks[shark][1] = 2 - sharks[shark][1];
              sharks[shark][3] = 3;
              if (sharks[shark][1] > C) {
                sharks[shark][1] = C * 2 - sharks[shark][1];
                sharks[shark][3] = 4;
              }
            }
            break;
        }
        int otherShark = nextBoard[sharks[shark][0]][sharks[shark][1]];
        if (otherShark == 0 || sharks[otherShark][4] < sharks[shark][4]) {
          removeSharkSet.add(otherShark);
          nextBoard[sharks[shark][0]][sharks[shark][1]] = shark;
        } else {
          removeSharkSet.add(shark);
        }
      }
      sharkSet.removeAll(removeSharkSet);
      board = nextBoard;
    }

    System.out.println(sum);
    br.close();
  }
}