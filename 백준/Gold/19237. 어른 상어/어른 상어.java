import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] moves = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Shark[] sharks = new Shark[M + 1];
    Smell[][] smellBoard = new Smell[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int sharkNo = Integer.parseInt(st.nextToken());
        if (sharkNo != 0) {
          smellBoard[i][j] = new Smell(0, sharkNo);
          Shark shark = new Shark(i, j, sharkNo, 0, null);
          sharks[sharkNo] = shark;
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int sharkNo = 1; sharkNo <= M; sharkNo++) {
      sharks[sharkNo].dir = Integer.parseInt(st.nextToken());
    }

    for (int sharkNo = 1; sharkNo <= M; sharkNo++) {
      int[][] dirPriority = new int[5][4];
      for (int i = 1; i <= 4; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 4; j++) {
          dirPriority[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      sharks[sharkNo].dirPriority = dirPriority;
    }

    // 상어 번호 순서대로 순회 가능하게 큐에 넣기
    Queue<Shark> sharkQ = new ArrayDeque<>();
    for (int sharkNo = 1; sharkNo <= M; sharkNo++) {
      sharkQ.offer(sharks[sharkNo]);
    }

    int answer = -1;
    for (int time = 1; time <= 1000; time++) {

      Queue<Shark> tempSharkQ = new ArrayDeque<>();

      loop: while (!sharkQ.isEmpty()) {
        Shark shark = sharkQ.poll();

        // 주변의 냄새가 없는 칸 탐색
        for (int nextDir : shark.dirPriority[shark.dir]) {
          int ny = shark.y + moves[nextDir][0];
          int nx = shark.x + moves[nextDir][1];
          if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
            if (smellBoard[ny][nx] == null || time - smellBoard[ny][nx].time > k) {
              shark.y = ny;
              shark.x = nx;
              shark.dir = nextDir;
              tempSharkQ.offer(shark);
              continue loop;
            }
          }
        }

        // 주변의 자신의 냄새가 있는 칸 탐색
        for (int nextDir : shark.dirPriority[shark.dir]) {
          int ny = shark.y + moves[nextDir][0];
          int nx = shark.x + moves[nextDir][1];
          if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
            if (smellBoard[ny][nx].sharkNo == shark.no) {
              shark.y = ny;
              shark.x = nx;
              shark.dir = nextDir;
              tempSharkQ.offer(shark);
              continue loop;
            }
          }
        }
      }

      // 상어가 같은 칸에 존재하면 배치하면 쫓겨남
      while (!tempSharkQ.isEmpty()) {
        Shark shark = tempSharkQ.poll();
        Smell smell = smellBoard[shark.y][shark.x];
        if (smell == null || smell.time != time) {
          smellBoard[shark.y][shark.x] = new Smell(time, shark.no);
          sharkQ.offer(shark);
        }
      }

      // 상어가 한마리만 있으면 종료
      if (sharkQ.size() == 1) {
        answer = time;
        break;
      }

    }

    System.out.println(answer);
    br.close();
  }

  static class Shark {
    int y;
    int x;
    int no;
    int dir;
    int[][] dirPriority;

    Shark(int y, int x, int no, int dir, int[][] dirPriority) {
      this.y = y;
      this.x = x;
      this.no = no;
      this.dir = dir;
      this.dirPriority = dirPriority;
    }

  }

  static class Smell {
    int time;
    int sharkNo;

    Smell(int time, int sharkNo) {
      this.time = time;
      this.sharkNo = sharkNo;
    }

  }
}