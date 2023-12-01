import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    char[][] board = new char[8][8];
    HashSet<Loc> wallSet = new HashSet<>();
    for (int i = 0; i < 8; i++) {
      board[i] = br.readLine().toCharArray();
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == '#') {
          wallSet.add(new Loc(i, j, -1));
        }
      }
    }

    int[][] moves = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 0, 0 } };
    int answer = 0;
    int count = 0;
    ArrayDeque<Loc> addStack = new ArrayDeque<>();
    ArrayDeque<Loc> removeStack = new ArrayDeque<>();
    Queue<Loc> bfs = new ArrayDeque<>();
    bfs.offer(new Loc(7, 0, 0));
    loop: while (bfs.size() > 0) {
      Loc state = bfs.poll();

      if (state.count > count) {
        count = state.count;
        for (Loc wall : wallSet) {
          if (wall.y < 7) {
            addStack.push(new Loc(wall.y + 1, wall.x, -1));
          }
          removeStack.push(wall);
        }
        while (removeStack.size() > 0) {
          wallSet.remove(removeStack.pop());
        }
        while (addStack.size() > 0) {
          wallSet.add(addStack.pop());
        }
      }

      if (wallSet.contains(state)) {
        continue;
      }

      state.count++;
      for (int[] m : moves) {
        int ny = state.y + m[0];
        int nx = state.x + m[1];
        if (ny >= 0 && ny < 8 && nx >= 0 && nx < 8) {
          if (ny == 0 && nx == 7) {
            answer = 1;
            break loop;
          }
          Loc nextLoc = new Loc(ny, nx, state.count);
          if (!wallSet.contains(nextLoc)) {
            bfs.offer(nextLoc);
          }
        }
      }
    }

    System.out.println(answer);
    br.close();
  }

  static class Loc {
    int y;
    int x;
    int count;

    Loc(int y, int x, int count) {
      this.y = y;
      this.x = x;
      this.count = count;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(this.y) + this.x;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Loc) {
        return this.y == ((Loc) obj).y && this.x == ((Loc) obj).x;

      } else {
        return false;
      }
    }

    @Override
    public String toString() {
      return y + " " + x;
    }

  }
}
