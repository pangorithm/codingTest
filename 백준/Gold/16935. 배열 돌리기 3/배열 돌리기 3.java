import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int m;
  static int[][] board;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    ArrayList<Integer> cmdList = new ArrayList<>();
    st = new StringTokenizer(in.readLine());
    for (int cmdCount = 0; cmdCount < r; cmdCount++) {
      cmdList.add(Integer.parseInt(st.nextToken()));
    }

    boolean notFinish = true;
    int index = 0;
    while (notFinish) {
      notFinish = false;
      for (int i = index; i < cmdList.size(); i++) {
        switch (cmdList.get(i)) {
          case 1:
            if (i + 1 < cmdList.size() && cmdList.get(i + 1) == 1) {
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            }
            break;
          case 2:
            if (i + 1 < cmdList.size() && cmdList.get(i + 1) == 2) {
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            }
            break;
          case 3:
            if (i + 1 < cmdList.size() && cmdList.get(i + 1) == 4) {
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            } else if (i + 3 < cmdList.size()
                && cmdList.get(i + 1) == 3 && cmdList.get(i + 2) == 3 && cmdList.get(i + 3) == 3) {
              cmdList.remove(i);
              cmdList.remove(i);
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            }
            break;
          case 4:
            if (i + 1 < cmdList.size() && cmdList.get(i + 1) == 3) {
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            } else if (i + 3 < cmdList.size()
                && cmdList.get(i + 1) == 4 && cmdList.get(i + 2) == 4 && cmdList.get(i + 3) == 4) {
              cmdList.remove(i);
              cmdList.remove(i);
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            }
            break;
          case 5:
            if (i + 1 < cmdList.size() && cmdList.get(i + 1) == 6) {
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            } else if (i + 3 < cmdList.size()
                && cmdList.get(i + 1) == 5 && cmdList.get(i + 2) == 5 && cmdList.get(i + 3) == 5) {
              cmdList.remove(i);
              cmdList.remove(i);
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            }
            break;
          case 6:
            if (i + 1 < cmdList.size() && cmdList.get(i + 1) == 5) {
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            } else if (i + 3 < cmdList.size()
                && cmdList.get(i + 1) == 6 && cmdList.get(i + 2) == 6 && cmdList.get(i + 3) == 6) {
              cmdList.remove(i);
              cmdList.remove(i);
              cmdList.remove(i);
              cmdList.remove(i);
              notFinish = true;
              index = i;
            }
            break;
        }
      }
    }

    for (int i = 0; i < cmdList.size(); i++) {
      f(cmdList.get(i));
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        sb.append(board[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
    in.close();
  }

  static void f(int cmd) {
    int[][] nextBoard;
    int lastIndex;
    int nm = n >> 1;
    int mm = m >> 1;
    switch (cmd) {
      case 1: // 상하 반전
        nextBoard = new int[n][m];
        lastIndex = n - 1;
        for (int i = 0; i < n; i++) {
          nextBoard[i] = board[lastIndex - i];
        }
        break;

      case 2: // 좌우 반전
        nextBoard = new int[n][m];
        lastIndex = m - 1;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            nextBoard[i][j] = board[i][lastIndex - j];
          }
        }
        break;

      case 3: // 시계방향 90도 회전
        nextBoard = new int[m][n];
        lastIndex = n - 1;
        for (int i = 0; i < n * m; i++) {
          nextBoard[i % m][lastIndex - (i / m)] = board[i / m][i % m];
        }
        n = nextBoard.length;
        m = nextBoard[0].length;
        break;

      case 4: // 반시계 방향 90도 회전
        nextBoard = new int[m][n];
        nextBoard = new int[m][n];
        lastIndex = m - 1;
        for (int i = 0; i < n * m; i++) {
          nextBoard[lastIndex - (i % m)][i / m] = board[i / m][i % m];
        }
        n = nextBoard.length;
        m = nextBoard[0].length;
        break;

      case 5: // 시계 방향 4분할 회전
        nextBoard = new int[n][m];
        for (int i = 0; i < nm; i++) {
          for (int j = 0; j < mm; j++) {
            nextBoard[i][j] = board[i + nm][j];
          }
        }
        for (int i = 0; i < nm; i++) {
          for (int j = mm; j < m; j++) {
            nextBoard[i][j] = board[i][j - mm];
          }
        }
        for (int i = nm; i < n; i++) {
          for (int j = mm; j < m; j++) {
            nextBoard[i][j] = board[i - nm][j];
          }
        }
        for (int i = nm; i < n; i++) {
          for (int j = 0; j < mm; j++) {
            nextBoard[i][j] = board[i][j + mm];
          }
        }
        break;

      case 6: // 반시계 방향 4분할 회전
        nextBoard = new int[n][m];
        for (int i = 0; i < nm; i++) {
          for (int j = 0; j < mm; j++) {
            nextBoard[i][j] = board[i][j + mm];
          }
        }
        for (int i = 0; i < nm; i++) {
          for (int j = mm; j < m; j++) {
            nextBoard[i][j] = board[i + nm][j];
          }
        }
        for (int i = nm; i < n; i++) {
          for (int j = mm; j < m; j++) {
            nextBoard[i][j] = board[i][j - mm];
          }
        }
        for (int i = nm; i < n; i++) {
          for (int j = 0; j < mm; j++) {
            nextBoard[i][j] = board[i - nm][j];
          }
        }
        break;

      default:
        nextBoard = new int[0][0];
    }
    board = nextBoard;
  }
}
