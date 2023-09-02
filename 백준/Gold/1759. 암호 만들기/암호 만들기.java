import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
  static int L;
  static int C;
  static char[] alphabets;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    alphabets = new char[C];
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < C; i++) {
      alphabets[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(alphabets);

    bfs(new StringBuilder(), 0, 0, 0);

    System.out.println(sb);
    in.close();
  }

  static void bfs(StringBuilder str, int length, int vCount, int startIndex) {
    if (length == L) {
      if (vCount > 0 && length - vCount > 1) {
        sb.append(str).append("\n");
      }
    } else {
      length++;
      for (int i = startIndex; i < C; i++) {
        int nextVCount = vCount;
        for (char vowel : vowels) {
          if (alphabets[i] == vowel) {
            nextVCount++;
            break;
          }
        }
        bfs(new StringBuilder(str).append(alphabets[i]), length, nextVCount, i + 1);
      }
    }
  }
}