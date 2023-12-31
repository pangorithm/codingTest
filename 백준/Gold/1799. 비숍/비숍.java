import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int size;
  static int[][] board;
  static int temp;
  static int[][] moves = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

  public static void main(String[] args) throws IOException {

    size = Integer.parseInt(br.readLine());
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < size; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int answer = 0;
    temp = 0;
    backTracking(0, 0);
    answer += temp;
    temp = 0;
    backTracking(1, 0);
    answer += temp;

    System.out.println(answer);

    br.close();
  }

  static void backTracking(int index, int count) {
    if (index >= size * size) {
      if (temp < count) {
        temp = count;
      }
      return;
    }

    int y = index / size;
    int x = index % size;
    int increase = calculateIncrease(index);

    if (board[y][x] == 1 && isValid(y, x)) {
      board[y][x] = 2;
      backTracking(index + increase, count + 1);
      board[y][x] = 1;
    }

    backTracking(index + increase, count);
  }

  public static int calculateIncrease(int index) {
    if ((size & 1) == 1) {
      return 2;
    } else {
      if (index % size == size - 1) {
        return 1;
      } else if (index % size == size - 2) {
        return 3;
      } else {
        return 2;
      }
    }
  }

  public static boolean isValid(int y, int x) {
    for (int[] m : moves) {
      int amt = 1;
      while (true) {
        int ny = y + amt * m[0];
        int nx = x + amt * m[1];
        if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
          break;
        }
        if (board[ny][nx] == 2) {
          return false;
        }
        amt++;
      }
    }
    return true;
  }

}
