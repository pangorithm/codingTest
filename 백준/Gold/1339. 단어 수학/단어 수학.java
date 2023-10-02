import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<char[]> wordList;
  static HashMap<Character, Integer> charMap;
  static int maxSum;

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    wordList = new ArrayList<>();
    charMap = new HashMap<>();
    int num = 9;
    for (int i = 0; i < n; i++) {
      char[] word = in.readLine().toCharArray();
      for (int j = 0; j < word.length; j++) {
        if (!charMap.containsKey(word[j])) {
          charMap.put(word[j], num--);
        }
      }
      wordList.add(word);
    }
    maxSum = 0;

    dfs(charMap.keySet().toArray(new Character[charMap.size()]), 0, getSum());

    System.out.println(maxSum);
    in.close();
  }

  private static void dfs(Character[] keys, Integer dept, int sum) {
    if (maxSum < sum) {
      maxSum = sum;
    }

    if (dept < keys.length) {
      dfs(keys, dept + 1, sum);
      Integer temp = charMap.get(keys[dept]);
      for (int i = dept + 1; i < keys.length; i++) {
        charMap.put(keys[dept], charMap.get(keys[i]));
        charMap.put(keys[i], temp);
        dfs(keys, dept + 1, getSum());
        charMap.put(keys[i], charMap.get(keys[dept]));
        charMap.put(keys[dept], temp);
      }
    }
  }

  private static int getSum() {
    int sum = 0;
    for (char[] word : wordList) {
      int num = 0;
      for (int i = 0; i < word.length; i++) {
        num *= 10;
        num += charMap.get(word[i]);
      }
      sum += num;
    }

    return sum;
  }
}
