package coding.algorithm.baekjoon;
//////////////////////////////////
import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder answer = new StringBuilder();

  public static void main(String[] args) throws IOException {


    /////////////////////////
    System.out.print(answer);
    in.close();
  }
}

/*
    // 한 라인에 하나의 변수가 있을 경우
    int n = Integer.parseInt(in.readLine());

    // 한 라인에 여러 입력이 있을 경우
    StringTokenizer st = new StringTokenizer(in.readLine());

    // 계속해서 라인으로 입력을 받을 경우
    String str;
    while((str = in.readLine()) != null){
      if(str.length() == 0){ break; } // 백준에서는 파일 입력이므로 불필요한 코드. 제출 시 주석처리 할 것
      int n = Integer.parseInt(str);
      answer.append(n).append("\n");
    }
*/