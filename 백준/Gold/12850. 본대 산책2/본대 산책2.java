import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int D;
  private static final int MOD = 1_000_000_007;
  private static int[] ansMatrix = { 0, 1, 0, 1, 0, 0, 0, 0 };
  private static long[][][] binaryMatrix = new long[32][8][8];
  private static int[][] matrix = {
      // 0 1 2 3 4 5 6 7
      { 0, 1, 0, 1, 0, 0, 0, 0 }, // 0
      { 1, 0, 1, 1, 0, 0, 0, 0 }, // 1
      { 0, 1, 0, 1, 1, 1, 0, 0 }, // 2
      { 1, 1, 1, 0, 0, 1, 0, 0 }, // 3
      { 0, 0, 1, 0, 0, 1, 1, 0 }, // 4
      { 0, 0, 1, 1, 1, 0, 0, 1 }, // 5
      { 0, 0, 0, 0, 1, 0, 0, 1 }, // 6
      { 0, 0, 0, 0, 0, 1, 1, 0 }, // 7
  };

  private static void initMatrix() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        binaryMatrix[0][i][j] = matrix[i][j];
      }
    }
    for (int i = 1; i < 32; i++) {
      binaryMatrix[i] = multiplicationMatrix(binaryMatrix[i - 1], binaryMatrix[i - 1]);
    }
  }

  private static long[][] multiplicationMatrix(long[][] a, long[][] b) {
    long[][] ans = new long[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        for (int k = 0; k < 8; k++) {
          ans[i][j] += a[i][k] * b[k][j];
          ans[i][j] %= MOD;
        }
      }
    }
    return ans;
  }

  private static int[] multiplicationMatrix(int[] a, long[][] b) {
    int[] ans = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[i].length; j++) {
        ans[i] += a[j] * b[i][j];
        ans[i] %= MOD;
      }
    }
    return ans;
  }

  public static void main(String[] args) throws IOException {
    D = Integer.parseInt(br.readLine());
    initMatrix();

    char[] chs = Integer.toBinaryString(D - 1).toCharArray();
    int size = chs.length;
    long[][] toMultiply = new long[8][8];
    for (int i = 0; i < 8; i++) {
      toMultiply[i][i] = 1;
    }
    for (int i = 0; i < size; i++) {
      if (chs[i] == '1') {
        toMultiply = multiplicationMatrix(toMultiply, binaryMatrix[size - i - 1]);
      }
    }
    ansMatrix = multiplicationMatrix(ansMatrix, toMultiply);

    System.out.println(ansMatrix[0]);
    br.close();

  }
}