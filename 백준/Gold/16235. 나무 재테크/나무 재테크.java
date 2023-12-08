import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] ground;
  static int[][] addNutrients;
  static PriorityQueue<Tree> treePQ;
  static Comparator<Tree> treeComparator = new Comparator<Main.Tree>() {
    public int compare(Tree t1, Tree t2) {
      return t1.age - t2.age;
    };
  };
  static int[][] moves = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ground = new int[N][N];
    addNutrients = new int[N][N];
    treePQ = new PriorityQueue<>(treeComparator);
    for (int i = 0; i < N; i++) {
      Arrays.fill(ground[i], 5);
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        addNutrients[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      int age = Integer.parseInt(st.nextToken());
      treePQ.offer(new Tree(x, y, age));
    }

    for (int year = 1; year <= K; year++) {
      summer(spring());
      fall();
      winter();
      // for (int i = 0; i < N; i++) {
      // System.out.println(Arrays.toString(ground[i]));
      // }
      // System.out.println(treePQ);
      // System.out.println();
    }

    System.out.println(treePQ.size());
    br.close();
  }

  static class Tree {
    int r;
    int c;
    int age;

    Tree(int x, int y, int age) {
      this.r = x;
      this.c = y;
      this.age = age;
    }

    @Override
    public String toString() {
      return new StringBuilder()
          .append('[')
          .append(this.r).append(' ')
          .append(this.c).append(' ')
          .append(this.age).append(']')
          .toString();
    }
  }

  static ArrayList<Tree> spring() {
    PriorityQueue<Tree> nextTreePQ = new PriorityQueue<>(treeComparator);
    ArrayList<Tree> deadTreeList = new ArrayList<>();

    while (!treePQ.isEmpty()) {
      Tree tree = treePQ.poll();
      if (ground[tree.r][tree.c] >= tree.age) {
        ground[tree.r][tree.c] -= tree.age++;
        nextTreePQ.offer(tree);
      } else {
        deadTreeList.add(tree);
      }
    }
    treePQ = nextTreePQ;

    return deadTreeList;
  }

  static void summer(ArrayList<Tree> deadTreeList) {
    for (Tree t : deadTreeList) {
      ground[t.r][t.c] += t.age >> 1;
    }
  }

  static void fall() {
    PriorityQueue<Tree> nextTreePQ = new PriorityQueue<>(treeComparator);

    while (!treePQ.isEmpty()) {
      Tree tree = treePQ.poll();
      if (tree.age % 5 == 0) {
        for (int[] m : moves) {
          int nextR = tree.r + m[0];
          int nextC = tree.c + m[1];
          if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
            nextTreePQ.offer(new Tree(nextR, nextC, 1));
          }
        }
      }
      nextTreePQ.offer(tree);
    }

    treePQ = nextTreePQ;
  }

  static void winter() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        ground[i][j] += addNutrients[i][j];
      }
    }
  }

}