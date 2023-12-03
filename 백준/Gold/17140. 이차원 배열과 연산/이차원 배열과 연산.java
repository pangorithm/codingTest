import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    r--;
    c--;

    int[][] matrix = new int[100][100];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    int maxRowLength = 3;
    int maxColLength = 3;
    while (matrix[r][c] != k && count++ < 100) {
      int[][] nextMatrix = new int[100][100];

      if (maxColLength >= maxRowLength) { // R연산
        maxRowLength = 0;

        for (int i = 0; i < maxColLength; i++) {
          ArrayList<Integer> list = new ArrayList<>();
          for (int j = 0; j < 100; j++) {
            if (matrix[i][j] > 0) {
              list.add(matrix[i][j]);
            }
          }

          int[] nextArr = sort(list);
          for (int j = 0; j < nextArr.length; j++) {
            nextMatrix[i][j] = nextArr[j];
          }

          if (maxRowLength < nextArr.length) {
            maxRowLength = nextArr.length;
          }
        }

      } else { // C연산
        maxColLength = 0;
        for (int j = 0; j < maxRowLength; j++) {
          ArrayList<Integer> list = new ArrayList<>();
          for (int i = 0; i < 100; i++) {
            if (matrix[i][j] > 0) {
              list.add(matrix[i][j]);
            }
          }
          int[] nextArr = sort(list);
          for (int i = 0; i < nextArr.length; i++) {
            nextMatrix[i][j] = nextArr[i];
          }

          if (maxColLength < nextArr.length) {
            maxColLength = nextArr.length;
          }
        }

      }

      // for (int i = 0; i < maxColLength; i++) {
      // System.out.println(Arrays.toString(nextMatrix[i]));
      // }
      // System.out.println(maxColLength + " " + maxRowLength);
      // System.out.println();
      matrix = nextMatrix;
    }

    if (matrix[r][c] == k) {
      System.out.println(count);
    } else {
      System.out.println(-1);
    }
    br.close();
  }

  static int[] sort(ArrayList<Integer> list) {
    HashMap<Integer, Integer> numMap = new HashMap<>();
    for (int num : list) {
      numMap.put(num, numMap.getOrDefault(num, 0) + 1);
    }
    ArrayList<Integer> keyList = new ArrayList<>(numMap.keySet());
    Collections.sort(keyList, (k1, k2) -> {
      int k1L = numMap.get(k1);
      int k2L = numMap.get(k2);
      if (k1L == k2L) {
        return k1 - k2;
      } else {
        return k1L - k2L;
      }
    });

    int[] resultArr = new int[numMap.size() << 1];
    for (int i = 0; i < keyList.size(); i++) {
      resultArr[i << 1] = keyList.get(i);
      resultArr[(i << 1) + 1] = numMap.get(keyList.get(i));
    }

    return resultArr;
  }
}