import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int k;
  static char[] signs;
  static boolean findedMax;
  static boolean findedMin;

  public static void main(String[] args) throws IOException {

    k = Integer.parseInt(in.readLine());
    signs = new char[k];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < k; i++) {
      signs[i] = st.nextToken().charAt(0);
    }
    findedMax = false;
    findedMin = false;

    searchMax(new int[k + 1], 0);
    searchMin(new int[k + 1], 0);

    System.out.println(sb);
    in.close();
  }

  static void searchMax(int[] numbers, int length) {
    if (findedMax) {
      return;
    }

    if (length == numbers.length) {
      if (valid(numbers)) {
        findedMax = true;
      }
    } else {
      int temp = numbers[length];
      loop: for (int n = 9; n >= 0; n--) {
        for (int i = 0; i < length; i++) {
          if (n == numbers[i]) {
            continue loop;
          }
        }
        numbers[length] = n;
        searchMax(numbers, length + 1);
      }
      numbers[length] = temp;
    }
  }

  static void searchMin(int[] numbers, int length) {
    if (findedMin) {
      return;
    }

    if (length == numbers.length) {
      if (valid(numbers)) {
        findedMin = true;
      }
    } else {
      int temp = numbers[length];
      loop: for (int n = 0; n <= 9; n++) {
        for (int i = 0; i < length; i++) {
          if (n == numbers[i]) {
            continue loop;
          }
        }
        numbers[length] = n;
        searchMin(numbers, length + 1);
      }
      numbers[length] = temp;
    }
  }

  static boolean valid(int[] numbers) {
    for (int i = 0; i < k; i++) {
      if (signs[i] == '<') {
        if (numbers[i] > numbers[i + 1]) {
          return false;
        }
      } else { // '>'
        if (numbers[i] < numbers[i + 1]) {
          return false;
        }
      }
    }

    for (int i = 0; i < numbers.length; i++) {
      sb.append(numbers[i]);
    }
    sb.append("\n");

    return true;
  }
}
