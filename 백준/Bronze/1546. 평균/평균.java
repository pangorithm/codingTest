import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    float[] scores = new float[n];
    float sum = 0;
    float maxScore = 0;
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      scores[i] = Float.parseFloat(st.nextToken());
      sum += scores[i];
      if (scores[i] > maxScore) {
        maxScore = scores[i];
      }
    }

    System.out.println(sum / n / maxScore * 100);
    in.close();
  }
}