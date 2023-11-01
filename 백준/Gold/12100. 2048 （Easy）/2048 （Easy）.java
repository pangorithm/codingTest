import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int max;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int[][] board = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] > max) {
          max = board[i][j];
        }
      }
    }
    dfs(board, 0);
    System.out.println(max);
    br.close();
  }

  static void dfs(int[][] board, int dept) {
    // printBoard(board);
    if (dept < 5) {
      dept++;

      int[][] nextBoard = new int[N][N];
      for (int i = 0; i < N; i++) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int j = 0; j < N; j++) {
          if (board[i][j] > 0) {
            tempList.add(board[i][j]);
          }
        }
        for (int j = 1; j < tempList.size(); j++) {
          if ((int) tempList.get(j) == (int) tempList.get(j - 1)) {
            tempList.set(j - 1, tempList.get(j) << 1);
            if (tempList.get(j - 1) > max) {
              max = tempList.get(j - 1);
            }
            tempList.set(j, 0);
          }
        }
        tempList.removeIf(no -> no == 0);
        for (int j = 0; j < tempList.size(); j++) {
          nextBoard[i][j] = tempList.get(j);
        }
      }
      dfs(nextBoard, dept);
      // printBoard(nextBoard);

      nextBoard = new int[N][N];
      for (int i = 0; i < N; i++) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int j = 0; j < N; j++) {
          if (board[j][i] > 0) {
            tempList.add(board[j][i]);
          }
        }
        for (int j = 1; j < tempList.size(); j++) {
          if ((int) tempList.get(j) == (int) tempList.get(j - 1)) {
            tempList.set(j - 1, tempList.get(j) << 1);
            if (tempList.get(j - 1) > max) {
              max = tempList.get(j - 1);
            }
            tempList.set(j, 0);
          }
        }
        tempList.removeIf(no -> no == 0);
        for (int j = 0; j < tempList.size(); j++) {
          nextBoard[j][i] = tempList.get(j);
        }
      }
      dfs(nextBoard, dept);
      // printBoard(nextBoard);

      nextBoard = new int[N][N];
      for (int i = 0; i < N; i++) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int j = 0; j < N; j++) {
          if (board[i][j] > 0) {
            tempList.add(0, board[i][j]);
          }
        }
        for (int j = 1; j < tempList.size(); j++) {
          if ((int) tempList.get(j) == (int) tempList.get(j - 1)) {
            tempList.set(j - 1, tempList.get(j) << 1);
            if (tempList.get(j - 1) > max) {
              max = tempList.get(j - 1);
            }
            tempList.set(j, 0);
          }
        }
        tempList.removeIf(no -> no == 0);
        for (int j = 0; j < tempList.size(); j++) {
          nextBoard[i][N - j - 1] = tempList.get(j);
        }
      }
      dfs(nextBoard, dept);
      // printBoard(nextBoard);

      nextBoard = new int[N][N];
      for (int i = 0; i < N; i++) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int j = 0; j < N; j++) {
          if (board[j][i] > 0) {
            tempList.add(0, board[j][i]);
          }
        }
        for (int j = 1; j < tempList.size(); j++) {
          if ((int) tempList.get(j) == (int) tempList.get(j - 1)) {
            tempList.set(j - 1, tempList.get(j) << 1);
            if (tempList.get(j - 1) > max) {
              max = tempList.get(j - 1);
            }
            tempList.set(j, 0);
          }
        }
        tempList.removeIf(no -> no == 0);
        for (int j = 0; j < tempList.size(); j++) {
          nextBoard[N - j - 1][i] = tempList.get(j);
        }
      }
      dfs(nextBoard, dept);
      // printBoard(nextBoard);
    }
  }

  static boolean check(int n) {
    if (n >= 0 && n < N) {
      return true;
    } else {
      return false;
    }
  }

  static void printBoard(int[][] board) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(Arrays.toString(board[i])).append("\n");
    }
    System.out.println(sb);
  }
}