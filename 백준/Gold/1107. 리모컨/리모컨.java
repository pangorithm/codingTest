import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static boolean[] buttons;
  static int N;
  static int nDigit;
  static int minDiff;

  public static void main(String[] args) throws IOException {

    N = Integer.parseInt(in.readLine());
    nDigit = getDigit(N);
    buttons = new boolean[10];
    Arrays.fill(buttons, true);
    int brokenButtonCount = Integer.parseInt(in.readLine());
    if (brokenButtonCount > 0) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      for (int i = 0; i < brokenButtonCount; i++) {
        buttons[Integer.parseInt(st.nextToken())] = false;
      }
    }
    minDiff = Math.abs(N - 100);

    for (int i = 0; i < 10; i++) {
      if (buttons[i]) {
        search(i, 1);
      }
    }

    System.out.println(minDiff);
    in.close();
  }

  private static void search(int value, int digit) {
    if (Math.abs(digit - nDigit) <= 1) {
      int diff = Math.abs(N - value) + digit;
      if (minDiff > diff) {
        minDiff = diff;
      }
    }

    if (digit <= nDigit) {
      value *= 10;
      for (int i = 0; i < 10; i++) {
        if (buttons[i]) {
          search(value + i, digit + 1);
        }
      }
    }
  }

  private static int getDigit(int n) {
    int digit = 1;
    while ((n /= 10) > 0) {
      digit++;
    }
    return digit;
  }
}
