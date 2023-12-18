import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int h;
  static int w;
  static char[][] board;
  static boolean[][] visit;
  static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
  static HashMap<Integer, HashSet<Integer>> graph;

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());

      board = new char[h][w];
      graph = new HashMap<>();
      graph.put(-1, new HashSet<>());
      ArrayList<int[]> prisonerList = new ArrayList<>();
      for (int i = 0; i < h; i++) {
        board[i] = br.readLine().toCharArray();
        for (int j = 0; j < w; j++) {
          if (board[i][j] == '#') {
            graph.put(encodeLoc(i, j), new HashSet<>());
          }
          if (board[i][j] == '$') {
            prisonerList.add(new int[] { i, j });
            board[i][j] = '.';
          }
        }
      }

      // 문에서 다른 어떤 문으로 갈 수 있는지
      visit = new boolean[h][w];
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (board[i][j] == '#') {
            Integer door = encodeLoc(i, j);
            for (int[] m : moves) {
              int ny = i + m[0];
              int nx = j + m[1];
              if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
                if (board[ny][nx] == '#') {
                  graph.get(door).add(encodeLoc(ny, nx));
                }
              } else {
                graph.get(door).add(-1);
                graph.get(-1).add(door);
              }
            }
          } else if (!visit[i][j] && board[i][j] == '.') {
            HashSet<Integer> foundDoorSet = findDoorSet(i, j);
            for (Integer door : foundDoorSet) {
              HashSet<Integer> doorSet = graph.get(door);
              doorSet.addAll(foundDoorSet);
              doorSet.remove(door);
            }
          }
        }
      }

      Integer prisoner0 = encodeLoc(prisonerList.get(0)[0], prisonerList.get(0)[1]);
      Integer prisoner1 = encodeLoc(prisonerList.get(1)[0], prisonerList.get(1)[1]);
      visit = new boolean[h][w];
      graph.put(prisoner0, findDoorSet(prisonerList.get(0)[0], prisonerList.get(0)[1]));
      for (Integer door : graph.get(prisoner0)) {
        graph.get(door).add(prisoner0);
      }
      visit = new boolean[h][w];
      graph.put(prisoner1, findDoorSet(prisonerList.get(1)[0], prisonerList.get(1)[1]));
      for (Integer door : graph.get(prisoner1)) {
        graph.get(door).add(prisoner1);
      }

      // System.out.println(graph);
      // System.out.println();

      HashMap<Integer, Integer> outDistMap = new HashMap<>();
      getDist(-1, 0, outDistMap);
      HashMap<Integer, Integer> prisoner0DistMap = new HashMap<>();
      getDist(prisoner0, 0, prisoner0DistMap);
      HashMap<Integer, Integer> prisoner1DistMap = new HashMap<>();
      getDist(prisoner1, 0, prisoner1DistMap);

      // System.out.println(outDistMap);
      // System.out.println(prisoner0DistMap);
      // System.out.println(prisoner1DistMap);

      int min = 10000;
      for (Integer door : graph.keySet()) {
        int sum = outDistMap.get(door) + prisoner0DistMap.get(door) + prisoner1DistMap.get(door);
        if (min > sum) {
          min = sum;
        }
      }

      sb.append(min - 2).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  static void getDist(Integer start, int dist, HashMap<Integer, Integer> map) {
    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.offer(new int[] { start, dist });
    map.put(start, dist);
    while (!bfs.isEmpty()) {
      int[] state = bfs.poll();
      state[1]++;
      for (Integer nextState : graph.get(state[0])) {
        if (!map.containsKey(nextState)) {
          map.put(nextState, state[1]);
          bfs.offer(new int[] { nextState, state[1] });
        }
      }
    }
  }

  static HashSet<Integer> findDoorSet(int i, int j) {
    HashSet<Integer> doorSet = new HashSet<>();
    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.offer(new int[] { i, j });
    visit[i][j] = true;
    while (!bfs.isEmpty()) {
      int[] state = bfs.poll();

      for (int[] m : moves) {
        int ny = state[0] + m[0];
        int nx = state[1] + m[1];
        if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
          if (!visit[ny][nx]) {
            if (board[ny][nx] == '.') {
              visit[ny][nx] = true;
              bfs.offer(new int[] { ny, nx });
            } else if (board[ny][nx] == '#') {
              doorSet.add(encodeLoc(ny, nx));
            }
          }
        } else {
          doorSet.add(-1);
        }
      }
    }

    return doorSet;
  }

  static int encodeLoc(int y, int x) {
    return y * w + x;
  }

  static int[] decodeLoc(int loc) {
    return new int[] { loc / w, loc % w };
  }

}
