import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] board;
  static int[] parents;
  
  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    parents = new int[N * M];
    for (int i = 0; i < N; i++) {
      char[] inputs = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        int node = i * M + j;
        switch(inputs[j]) {
          case 'U':
            board[i][j] = node - M;
            break;
          case 'D':
            board[i][j] = node + M;
            break;
          case 'L':
            board[i][j] = node - 1;
            break;
          case 'R':
            board[i][j] = node + 1;
            break;
        }
        parents[node] = node;
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++){
        int node = i * M + j;
        if(parents[node] == node) {
          union(node, board[i][j]);  
        }
      }
    }

    int count = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        int node = i * M + j;
        if (parents[node] == node) {
          count++;
        }
      }
    }
      
    System.out.println(count);
    br.close();
  }

  static int getRoot(int x) {
    if(parents[x] == x) {
      return x;
    } else {
      return getRoot(parents[x]);
    }
  }

  static boolean union(int a, int b) {
    int rootA = getRoot(a);
    int rootB = getRoot(b);
    if(rootA == rootB) {
      return false;
    } else {
      parents[rootA] = rootB;
      return true;
    }
  }
    
}