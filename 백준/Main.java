package coding.algorithm.baekjoon;

//////////////////////////////////
import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();
    sb.append("test");
    System.out.println(sb);

    in.close();
  }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
private class MemoForMe {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder(); // 긴 결과 제출 시 시용할것

  public static void memo(String[] args) throws IOException {

    // 한 라인에 하나의 변수가 있을 경우
    int n = Integer.parseInt(in.readLine());

    // 한 라인에 여러 입력이 있을 경우
    StringTokenizer st = new StringTokenizer(in.readLine());

    // 계속해서 라인으로 입력을 받을 경우
    String str;
    while ((str = in.readLine()) != null) {
      if (str.length() == 0) {
        break;
      } // 백준에서는 파일 입력이므로 불필요한 코드. 제출 시 주석처리 할 것
      int x = Integer.parseInt(str);
      sb.append(n).append("\n");
    }

    // toString() 없이 제출 가능
    System.out.pirnt(sb);
  }
}