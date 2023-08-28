import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException {

    String str;
    while((str = br.readLine()) != null){
      int n = Integer.parseInt(str);
      int kn = 1;
      int count = 1;
      while((kn = kn%n) != 0){
        kn *= 10;
        kn++;
        count++;
      }
      bw.write(count + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
