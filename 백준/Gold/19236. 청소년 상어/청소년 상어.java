import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] moves = { { 0, 0 },
      { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };

  public static void main(String[] args) throws IOException {

    Fish[][] board = new Fish[4][4];
    TreeSet<Fish> fishSet = new TreeSet<>((f1, f2) -> f1.no - f2.no);
    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        Fish fish = new Fish(i, j, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        board[i][j] = fish;
        fishSet.add(fish);
      }
    }

    Fish shark = board[0][0];
    board[0][0] = null;
    fishSet.remove(shark);
    System.out.println(backTracking(shark.no, board, fishSet, shark));

    br.close();
  }

  static int backTracking(int sum, Fish[][] beforeBoard, TreeSet<Fish> beforeFishSet, Fish beforeShark) {
    // printBoard(beforeBoard);

    Fish[][] board = new Fish[4][4];
    TreeSet<Fish> fishSet = new TreeSet<>((f1, f2) -> f1.no - f2.no);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        Fish fish = null;
        if (beforeBoard[i][j] != null) {
          Fish beforeFish = beforeBoard[i][j];
          fish = new Fish(beforeFish.y, beforeFish.x, beforeFish.no, beforeFish.dir);
          fishSet.add(fish);
        }
        board[i][j] = fish;
      }
    }
    Fish shark = new Fish(beforeShark.y, beforeShark.x, beforeShark.no, beforeShark.dir);

    int max = sum;
    for (Fish fish : fishSet) {
      for (int i = 0; i < 8 && !checkMoveable(fish, shark); i++) {
        fish.dir++;
        if (fish.dir > 8) {
          fish.dir -= 8;
        }
      }
      if (checkMoveable(fish, shark)) {
        int ny = fish.y + moves[fish.dir][0];
        int nx = fish.x + moves[fish.dir][1];
        Fish otherFish = board[ny][nx];
        board[fish.y][fish.x] = otherFish;
        if (otherFish != null) {
          otherFish.y = fish.y;
          otherFish.x = fish.x;
        }
        board[ny][nx] = fish;
        fish.y = ny;
        fish.x = nx;
      }
    }

    while (checkMoveable(shark, shark)) {
      shark.y += moves[shark.dir][0];
      shark.x += moves[shark.dir][1];

      Fish ateFish = board[shark.y][shark.x];
      if (ateFish != null) {
        board[shark.y][shark.x] = null;
        fishSet.remove(ateFish);
        Fish tempShark = shark;
        shark = ateFish;
        max = Math.max(max, backTracking(sum + ateFish.no, board, fishSet, shark));
        board[shark.y][shark.x] = ateFish;
        fishSet.add(ateFish);
        shark = tempShark;
      }
    }

    return max;
  }

  static boolean checkMoveable(Fish f, Fish shark) {
    int ny = f.y + moves[f.dir][0];
    int nx = f.x + moves[f.dir][1];
    if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || (shark.y == ny && shark.x == nx)) {
      return false;
    } else {
      return true;
    }
  }

  static class Fish {
    int y;
    int x;
    int no;
    int dir;

    Fish(int y, int x, int no, int dir) {
      this.y = y;
      this.x = x;
      this.no = no;
      this.dir = dir;
    }

    @Override
    public String toString() {
      // TODO Auto-generated method stub
      return y + " " + x + " " + no + " " + dir;
    }
  }

  static void printBoard(Fish[][] board) {
    StringBuilder sb = new StringBuilder();
    for (Fish[] arr : board) {
      sb.append(Arrays.toString(arr)).append("\n");
    }
    System.out.println(sb);
  }
}