import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    int s = Integer.parseInt(st.nextToken());
    char[] n = st.nextToken().toCharArray();

    char[][][] defaultNums = new char[][][] {
        {
            { ' ', '-', ' ', ' ' },
            { '|', ' ', '|', ' ' },
            { ' ', ' ', ' ', ' ' },
            { '|', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' } },
        {
            { ' ', ' ', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', ' ', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', ' ', ' ', ' ' } },
        {
            { ' ', '-', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' },
            { '|', ' ', ' ', ' ' },
            { ' ', '-', ' ', ' ' } },
        {
            { ' ', '-', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' } },
        {
            { ' ', ' ', ' ', ' ' },
            { '|', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', ' ', ' ', ' ' } },
        {
            { ' ', '-', ' ', ' ' },
            { '|', ' ', ' ', ' ' },
            { ' ', '-', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' } },
        {
            { ' ', '-', ' ', ' ' },
            { '|', ' ', ' ', ' ' },
            { ' ', '-', ' ', ' ' },
            { '|', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' } },
        {
            { ' ', '-', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', ' ', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', ' ', ' ', ' ' } },
        {
            { ' ', '-', ' ', ' ' },
            { '|', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' },
            { '|', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' } },
        {
            { ' ', '-', ' ', ' ' },
            { '|', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' },
            { ' ', ' ', '|', ' ' },
            { ' ', '-', ' ', ' ' } }
    };

    char[][][] nums = new char[10][(s << 1) + 3][s + 3];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < nums[0].length; j++) {
        for (int k = 0; k < nums[0][0].length; k++) {
          nums[i][j][k] = ' ';
        }
      }
    }
    for (int num = 0; num < 10; num++) {
      if (defaultNums[num][0][1] == '-') {
        for (int count = 0; count < s; count++) {
          nums[num][0][1 + count] = '-';
        }
      }
      if (defaultNums[num][1][0] == '|') {
        for (int count = 0; count < s; count++) {
          nums[num][1 + count][0] = '|';
        }
      }
      if (defaultNums[num][1][2] == '|') {
        for (int count = 0; count < s; count++) {
          nums[num][1 + count][1 + s] = '|';
        }
      }
      if (defaultNums[num][2][1] == '-') {
        for (int count = 0; count < s; count++) {
          nums[num][1 + s][1 + count] = '-';
        }
      }
      if (defaultNums[num][3][0] == '|') {
        for (int count = 0; count < s; count++) {
          nums[num][2 + s + count][0] = '|';
        }
      }
      if (defaultNums[num][3][2] == '|') {
        for (int count = 0; count < s; count++) {
          nums[num][2 + s + count][1 + s] = '|';
        }
      }
      if (defaultNums[num][4][1] == '-') {
        for (int count = 0; count < s; count++) {
          nums[num][(1 + s) << 1][1 + count] = '-';
        }
      }
    }

    char[][] screen = new char[(s << 1) + 3][(s + 3) * n.length];
    for (int i = 0; i < n.length; i++) {
      for (int y = 0; y < nums[0].length; y++) {
        for (int x = 0; x < nums[0][0].length; x++) {
          screen[y][(s + 3) * i + x] = nums[n[i] - '0'][y][x];
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < screen.length; i++) {
      sb.append(String.valueOf(screen[i])).append("\n");
    }

    System.out.println(sb);

    in.close();
  }
}