import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static List<Integer> commandList;
  static int[][][] dp;
  static int N;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    commandList = new ArrayList<>();
    int command;
    while ((command = Integer.parseInt(st.nextToken())) != 0) {
      commandList.add(command);
    }

    N = commandList.size();
    dp = new int[5][5][commandList.size()]; // {왼발, 오른발, command}
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    System.out.println(dfsSearch(0, 0, 0));

    br.close();
  }

  static int dfsSearch(int left, int right, int step) {
    if (step == N) {
      return 0;
    }
    if (dp[left][right][step] != -1) {
      return dp[left][right][step];
    }
    return dp[left][right][step] = Math.min(
        dfsSearch(commandList.get(step), right, step + 1) + getUsePower(left, commandList.get(step)),
        dfsSearch(left, commandList.get(step), step + 1) + getUsePower(right, commandList.get(step)));
  }

  static int getUsePower(int before, int after) {
    if (before == after) {
      return 1;
    } else if (before == 0) {
      return 2;
    } else if (((before + after) & 1) == 1) {
      return 3;
    } else {
      return 4;
    }
  }
}