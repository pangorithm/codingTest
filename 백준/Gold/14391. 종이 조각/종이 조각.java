import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[][] numBoard;
  static int[][] stateBoard;
  static HashMap<Integer, Integer> stateMap;
  static Entry[] entryArr;
  static int maxState;
  static int max;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    numBoard = new int[N][M];
    stateBoard = new int[N][M];
    for (int i = 0; i < N; i++) {
      char[] numChars = in.readLine().toCharArray();
      int index = 0;
      for (int j = 0; j < M; j++) {
        numBoard[i][j] = numChars[index++] - '0';

        StringBuilder stateStr = new StringBuilder("1");
        for (int k = 0; k < i * M + j; k++) {
          stateStr.append("0");
        }
        stateBoard[i][j] = Integer.parseInt(stateStr.toString(), 2);
      }
    }

    int num;
    int state;
    stateMap = new HashMap<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        num = numBoard[i][j];
        state = stateBoard[i][j];
        stateMap.put(state, num);
        for (int k = i + 1; k < N; k++) {
          num *= 10;
          num += numBoard[k][j];
          state |= stateBoard[k][j];
          stateMap.put(state, num);
        }

        num = numBoard[i][j];
        state = stateBoard[i][j];
        for (int k = j + 1; k < M; k++) {
          num *= 10;
          num += numBoard[i][k];
          state |= stateBoard[i][k];
          stateMap.put(state, num);
        }
      }
    }
    entryArr = stateMap.entrySet().toArray(new Entry[stateMap.size()]);
    maxState = (1 << (N * M)) - 1;

    max = 0;

    dfs(0, 0, 0);

    System.out.print(max);
    in.close();
  }

  static void dfs(int boardState, int sum, int startIndex) {
    if (boardState == maxState) {
      if (max < sum) {
        max = sum;
      }
    } else {
      for (int i = startIndex; i < entryArr.length; i++) {
        int state = (int) entryArr[i].getKey();
        if ((boardState & state) == 0) {
          dfs(boardState | state, sum + (int) entryArr[i].getValue(), i + 1);
        }
      }
    }
  }
}