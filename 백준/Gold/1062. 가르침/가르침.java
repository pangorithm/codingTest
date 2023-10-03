import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int k;
  static ArrayList<Integer> wordBitList;
  static int minBitMask;
  static int maxBitMask;
  static int maxCount;
  static boolean[] visited = new boolean[1 << 26];

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int baseBit = 0;
    char[] baseWord = "antic".toCharArray();
    for (char c : baseWord) {
      baseBit |= 1 << (c - 'a');
    }

    wordBitList = new ArrayList<>();
    minBitMask = Integer.MAX_VALUE;
    maxBitMask = 0;
    for (int i = 0; i < n; i++) {
      char[] word = in.readLine().toCharArray();
      int wordBit = baseBit;
      for (int j = 4; j <= word.length - 4; j++) {
        wordBit |= 1 << (word[j] - 'a');
      }
      if (Integer.bitCount(wordBit) <= k) {
        wordBitList.add(wordBit);
        minBitMask &= wordBit;
        maxBitMask |= wordBit;
      }
    }

    if (k < Integer.bitCount(minBitMask)) {
      System.out.println(0);
    } else if (Integer.bitCount(maxBitMask) <= k) {
      System.out.println(wordBitList.size());
    } else {
      maxCount = 0;
      dfs(minBitMask, 0, 0);
      System.out.println(maxCount);
    }

    in.close();
  }

  static void dfs(int bitmask, int count, int startIndex) {
    if (count > maxCount) {
      maxCount = count;
    }
    for (int i = startIndex; i < wordBitList.size(); i++) {
      int nextBitmask = bitmask | wordBitList.get(i);
      if (!visited[nextBitmask]) {
        if (Integer.bitCount(nextBitmask) <= k) {
          dfs(nextBitmask, count + 1, i + 1);
        }
        visited[nextBitmask] = true;
      }
    }
  }

}