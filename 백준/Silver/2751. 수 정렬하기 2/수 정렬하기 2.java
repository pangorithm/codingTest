import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    ArrayList<Integer> numList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      numList.add(Integer.parseInt(in.readLine()));
    }
    Collections.sort(numList);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(numList.get(i)).append("\n");
    }
    System.out.println(sb);
    in.close();
  }
}