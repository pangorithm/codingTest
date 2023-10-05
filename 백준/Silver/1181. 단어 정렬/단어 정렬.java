import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    HashSet<String> strSet = new HashSet<>();
    for (int i = 0; i < n; i++) {
      strSet.add(in.readLine());
    }
    ArrayList<String> strList = new ArrayList<>(strSet);
    Collections.sort(strList, (s1, s2) -> {
      if (s1.length() != s2.length()) {
        return s1.length() - s2.length();
      } else {
        return s1.compareTo(s2);
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strList.size(); i++) {
      sb.append(strList.get(i)).append("\n");
    }

    System.out.println(sb);
    in.close();
  }
}