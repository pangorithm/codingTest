import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int fileCount;
  static char[][] board;
  static HashSet<Character> keySet;
  static HashMap<Character, ArrayList<int[]>> doorMap;
  static Queue<int[]> bfs;

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();
    int testCount = Integer.parseInt(br.readLine());
    for (int t = 0; t < testCount; t++) {

      fileCount = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      board = new char[h][w];
      for (int i = 0; i < h; i++) {
        board[i] = br.readLine().toCharArray();
      }

      keySet = new HashSet<>();
      char[] keys = br.readLine().toUpperCase().toCharArray();
      for (char c : keys) {
        keySet.add(c);
      }

      doorMap = new HashMap<>();
      bfs = new ArrayDeque<>();
      int lastNyIndex = h - 1;
      int lastNxIndex = w - 1;
      for (int i = 0; i < h; i++) {
        if (board[i][0] != '*') {
          visitBoard(i, 0);
        }
        if (board[i][lastNxIndex] != '*') {
          visitBoard(i, lastNxIndex);
        }
      }
      for (int j = 0; j < w; j++) {
        if (board[0][j] != '*') {
          visitBoard(0, j);
        }
        if (board[lastNyIndex][j] != '*') {
          visitBoard(lastNyIndex, j);
        }
      }

      int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
      while (bfs.size() > 0) {
        int[] loc = bfs.poll();
        for (int[] m : moves) {
          int ny = loc[0] + m[0];
          int nx = loc[1] + m[1];
          if (ny > 0 && ny < lastNyIndex && nx > 0 && nx < lastNxIndex && board[ny][nx] != '*') {
            visitBoard(ny, nx);
          }
        }
      }

      sb.append(fileCount).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  static void visitBoard(int y, int x) {
    char c = board[y][x];

    if (c == '.') {
      board[y][x] = '*';
      bfs.offer(new int[] { y, x });
    } else {
      if (c >= 'a' && c <= 'z') {
        c = Character.toUpperCase(c);
        keySet.add(c);
        board[y][x] = '*';
        bfs.offer(new int[] { y, x });
        if (doorMap.containsKey(c)) {
          ArrayList<int[]> list = doorMap.get(c);
          for (int[] loc : list) {
            board[loc[0]][loc[1]] = '*';
            bfs.offer(loc);
          }
          doorMap.remove(c);
        }
      } else if (c >= 'A' && c <= 'Z') {
        if (keySet.contains(c)) {
          board[y][x] = '*';
          bfs.offer(new int[] { y, x });
        } else {
          ArrayList<int[]> list = doorMap.getOrDefault(c, new ArrayList<>());
          list.add(new int[] { y, x });
          doorMap.put(c, list);
        }
      } else {
        board[y][x] = '*';
        bfs.offer(new int[] { y, x });
        fileCount++;
      }
    }
  }
}
