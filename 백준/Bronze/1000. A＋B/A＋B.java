import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] str) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      String[] inStrs = br.readLine().split(" ");
      bw.write(Integer.toString(Integer.parseInt(inStrs[0]) + Integer.parseInt(inStrs[1])));
    } catch (IOException ioE) {
      // TODO: handle exception
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
