import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {

      boolean[] visited = new boolean[10000];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      Queue<State> bfs = new ArrayDeque<>();
      bfs.offer(new State(A, new StringBuilder()));
      visited[A] = true;
      while (true) {
        State state = bfs.poll();

        State nextState = new State(D(state.n), new StringBuilder(state.sb).append('D'));
        if (nextState.n == B) {
          sb.append(nextState.sb).append('\n');
          break;
        } else if (!visited[nextState.n]) {
          bfs.offer(nextState);
          visited[nextState.n] = true;
        }
        nextState = new State(S(state.n), new StringBuilder(state.sb).append('S'));
        if (nextState.n == B) {
          sb.append(nextState.sb).append('\n');
          break;
        } else if (!visited[nextState.n]) {
          bfs.offer(nextState);
          visited[nextState.n] = true;
        }
        nextState = new State(L(state.n), new StringBuilder(state.sb).append('L'));
        if (nextState.n == B) {
          sb.append(nextState.sb).append('\n');
          break;
        } else if (!visited[nextState.n]) {
          bfs.offer(nextState);
          visited[nextState.n] = true;
        }
        nextState = new State(R(state.n), new StringBuilder(state.sb).append('R'));
        if (nextState.n == B) {
          sb.append(nextState.sb).append('\n');
          break;
        } else if (!visited[nextState.n]) {
          bfs.offer(nextState);
          visited[nextState.n] = true;
        }
      }

    }

    System.out.println(sb);
    br.close();
  }

  static class State {
    int n;
    StringBuilder sb;

    State(int n, StringBuilder sb) {
      this.n = n;
      this.sb = sb;
    }
  }

  static int D(int n) {
    return (n << 1) % 10000;
  }

  static int S(int n) {
    return n == 0 ? 9999 : n - 1;
  }

  static int L(int n) {
    return (n % 1000) * 10 + (n / 1000);
  }

  static int R(int n) {
    return (n % 10) * 1000 + (n / 10);
  }
}