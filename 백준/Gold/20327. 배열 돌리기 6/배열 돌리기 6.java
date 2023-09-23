import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[][] board;
  static int length;
  static int subLength;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    length = 1 << n;
    board = new int[length][length];
    for (int i = 0; i < length; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < length; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int cmdCount = 0; cmdCount < r; cmdCount++) {
      st = new StringTokenizer(in.readLine());
      int k = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());
      subLength = 1 << l;
      if (k < 5) {
        for (int i = 0; i < length; i += subLength) {
          for (int j = 0; j < length; j += subLength) {
            int[][] subBoard = new int[subLength][subLength];
            for (int y = 0; y < subLength; y++) {
              for (int x = 0; x < subLength; x++) {
                subBoard[y][x] = board[i + y][j + x];
              }
            }
            subBoard = f(k, subBoard);
            for (int y = 0; y < subLength; y++) {
              for (int x = 0; x < subLength; x++) {
                board[i + y][j + x] = subBoard[y][x];
              }
            }
          }
        }
      } else {
        subLength = length >> l;
        int[][] subBoard = new int[subLength][subLength];
        int index = 0;
        for (int i = 0; i < subLength; i++) {
          for (int j = 0; j < subLength; j++) {
            subBoard[i][j] = index++;
          }
        }
        subBoard = f(k - 4, subBoard);

        int[][] nextBoard = new int[length][length];
        for (int i = 0; i < subLength; i++) {
          for (int j = 0; j < subLength; j++) {
            int startY = subBoard[i][j] / subLength;
            int startX = subBoard[i][j] % subLength;
            int miniLength = 1 << l;
            for (int y = 0; y < miniLength; y++) {
              for (int x = 0; x < miniLength; x++) {
                nextBoard[i * miniLength + y][j * miniLength + x] = board[startY * miniLength + y][startX * miniLength
                    + x];
              }
            }
          }
        }
        board = nextBoard;
      }
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

  static int[][] f(int k, int[][] subBoard) {
    int[][] nextBoard = new int[subLength][subLength];
    int lastIndex = subLength - 1;
    switch (k) {
      case 1: // 상하 반전
        for (int i = 0; i < subLength; i++) {
          nextBoard[i] = subBoard[lastIndex - i];
        }
        break;

      case 2: // 좌우 반전
        for (int i = 0; i < subLength; i++) {
          for (int j = 0; j < subLength; j++) {
            nextBoard[i][j] = subBoard[i][lastIndex - j];
          }
        }
        break;

      case 3: // 시계방향 90도 회전
        for (int i = 0; i < subLength * subLength; i++) {
          nextBoard[i % subLength][lastIndex - (i / subLength)] = subBoard[i / subLength][i % subLength];
        }
        break;

      case 4: // 반시계 방향 90도 회전
        for (int i = 0; i < subLength * subLength; i++) {
          nextBoard[lastIndex - (i % subLength)][i / subLength] = subBoard[i / subLength][i % subLength];
        }
        break;

      default:
        nextBoard = new int[0][0];
    }
    return nextBoard;
  }
}