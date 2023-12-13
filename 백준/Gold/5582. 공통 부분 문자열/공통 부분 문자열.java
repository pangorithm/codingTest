import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    char[] chars1 = (" " + br.readLine()).toCharArray();
    char[] chars2 = (" " + br.readLine()).toCharArray();
    int[][] lcs = new int[chars1.length][chars2.length];

    int max = 0;
    for (int i = 1; i < chars1.length; i++) {
      for (int j = 1; j < chars2.length; j++) {
        if (chars1[i] == chars2[j]) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        }
        if (max < lcs[i][j]) {
          max = lcs[i][j];
        }
      }
    }

    System.out.println(max);
    br.close();
  }
}