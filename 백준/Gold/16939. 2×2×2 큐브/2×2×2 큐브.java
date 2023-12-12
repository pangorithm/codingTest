import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int[][] cube = new int[6][8];
    StringTokenizer st = new StringTokenizer(br.readLine());
    cube[0][2] = Integer.parseInt(st.nextToken());
    cube[0][3] = Integer.parseInt(st.nextToken());
    cube[1][2] = Integer.parseInt(st.nextToken());
    cube[1][3] = Integer.parseInt(st.nextToken());
    cube[2][2] = Integer.parseInt(st.nextToken());
    cube[2][3] = Integer.parseInt(st.nextToken());
    cube[3][2] = Integer.parseInt(st.nextToken());
    cube[3][3] = Integer.parseInt(st.nextToken());
    cube[4][2] = Integer.parseInt(st.nextToken());
    cube[4][3] = Integer.parseInt(st.nextToken());
    cube[5][2] = Integer.parseInt(st.nextToken());
    cube[5][3] = Integer.parseInt(st.nextToken());
    cube[2][0] = Integer.parseInt(st.nextToken());
    cube[2][1] = Integer.parseInt(st.nextToken());
    cube[3][0] = Integer.parseInt(st.nextToken());
    cube[3][1] = Integer.parseInt(st.nextToken());
    cube[2][4] = Integer.parseInt(st.nextToken());
    cube[2][5] = Integer.parseInt(st.nextToken());
    cube[3][4] = Integer.parseInt(st.nextToken());
    cube[3][5] = Integer.parseInt(st.nextToken());
    cube[2][6] = Integer.parseInt(st.nextToken());
    cube[2][7] = Integer.parseInt(st.nextToken());
    cube[3][6] = Integer.parseInt(st.nextToken());
    cube[3][7] = Integer.parseInt(st.nextToken());

    // printCube(cube);
    int answer = 0;

    for (int i = 1; i <= 4; i++) {
      cube = rotateX(cube);
      if ((i & 1) == 1 && check(cube)) {
        answer = 1;
      }
      // printCube(cube);
    }

    for (int i = 1; i <= 4; i++) {
      cube = rotateY(cube);
      if ((i & 1) == 1 && check(cube)) {
        answer = 1;
      }
      // printCube(cube);
    }

    for (int i = 1; i <= 4; i++) {
      cube = rotateZ(cube);
      if ((i & 1) == 1 && check(cube)) {
        answer = 1;
      }
      // printCube(cube);
    }

    System.out.println(answer);
    br.close();
  }

  static void printCube(int[][] cube) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      sb.append(Arrays.toString(cube[i])).append("\n");
    }
    System.out.println(sb);
  }

  static boolean check(int[][] cube) {
    return (cube[0][2] == cube[0][3] && cube[0][2] == cube[1][2] && cube[0][2] == cube[1][3])
        && (cube[2][2] == cube[2][3] && cube[2][2] == cube[3][2] && cube[2][2] == cube[3][3])
        && (cube[4][2] == cube[4][3] && cube[4][2] == cube[5][2] && cube[4][2] == cube[5][3])
        && (cube[2][0] == cube[2][1] && cube[2][0] == cube[3][0] && cube[2][0] == cube[3][1])
        && (cube[2][4] == cube[2][5] && cube[2][4] == cube[3][4] && cube[2][4] == cube[3][5])
        && (cube[2][6] == cube[2][7] && cube[2][6] == cube[3][6] && cube[2][6] == cube[3][7]);
  }

  static int[][] rotateZ(int[][] cube) {
    int temp1 = cube[0][2];
    int temp2 = cube[0][3];
    cube[0][2] = cube[3][0];
    cube[0][3] = cube[2][0];
    cube[2][0] = cube[5][2];
    cube[3][0] = cube[5][3];
    cube[5][2] = cube[3][5];
    cube[5][3] = cube[2][5];
    cube[2][5] = temp1;
    cube[3][5] = temp2;
    return cube;
  }

  static int[][] rotateY(int[][] cube) {
    int temp1 = cube[0][2];
    int temp2 = cube[1][2];
    for (int i = 0; i < 4; i++) {
      cube[i][2] = cube[i + 2][2];
    }
    cube[4][2] = cube[3][7];
    cube[5][2] = cube[2][7];
    cube[3][7] = temp1;
    cube[2][7] = temp2;
    return cube;
  }

  static int[][] rotateX(int[][] cube) {
    int temp1 = cube[2][0];
    int temp2 = cube[2][1];
    for (int i = 0; i < 6; i++) {
      cube[2][i] = cube[2][i + 2];
    }
    cube[2][6] = temp1;
    cube[2][7] = temp2;
    return cube;
  }
}