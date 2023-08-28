package coding.algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] str) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());



    bw.write(n + "\n");
    bw.close();
    br.close();
  }
}
