import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static boolean[] S;

  public static void main(String[] args) throws IOException {
    int M = Integer.parseInt(in.readLine());
    S = new boolean[21];
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      String command = st.nextToken();
      int x;
      switch (command) {
        case "add":
          x = Integer.parseInt(st.nextToken());
          S[x] = true;
          break;
        case "remove":
          x = Integer.parseInt(st.nextToken());
          S[x] = false;
          break;
        case "check":
          x = Integer.parseInt(st.nextToken());
          sb.append(S[x] ? "1" : "0").append("\n");
          break;
        case "toggle":
          x = Integer.parseInt(st.nextToken());
          S[x] = !S[x];
          break;
        case "all":
          Arrays.fill(S, true);
          break;
        case "empty":
          Arrays.fill(S, false);
          break;
      }
    }

    System.out.println(sb);
    in.close();
  }
}