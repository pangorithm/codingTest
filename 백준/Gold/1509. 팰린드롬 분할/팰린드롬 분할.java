import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static char[] arr;
  static int[][] isPalindrome;
  static int[] dp;

  public static void main(String[] args) throws IOException {

    arr = br.readLine().toCharArray();

    isPalindrome = new int[arr.length][arr.length];
    dp = new int[arr.length];
    Arrays.fill(dp, Integer.MAX_VALUE);

    System.out.println(search(0));
    br.close();
  }

  static boolean checkPalindrome(int start, int end) {
    if (start > end) {
      return true;
    }

    if (isPalindrome[start][end] == 0) {
      if (arr[start] == arr[end] && checkPalindrome(start + 1, end - 1)) {
        isPalindrome[start][end] = 1;
      } else {
        isPalindrome[start][end] = -1;
      }
    }
    if (isPalindrome[start][end] == 1) {
      return true;
    } else {
      return false;
    }
  }

  static int search(int start) {
    if (start == arr.length) {
      return 0;
    }

    if (dp[start] < Integer.MAX_VALUE) {
      return dp[start];
    }

    for (int end = start; end < arr.length; end++) {
      if (checkPalindrome(start, end)) {
        dp[start] = Math.min(dp[start], search(end + 1) + 1);
      }
    }

    return dp[start];
  }
}
