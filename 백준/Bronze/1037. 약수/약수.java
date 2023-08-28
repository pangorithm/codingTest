import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    int min = Integer.MAX_VALUE;
    int max = 0;
    StringTokenizer st = new StringTokenizer(in.readLine());
    while(st.hasMoreTokens()){
      int x = Integer.parseInt(st.nextToken());
      if(x > max){
        max = x;
      }
      if(x < min){
        min = x;
      }
    }

    /////////////////////////
    System.out.print(String.valueOf(min * max));
    in.close();
  }
}