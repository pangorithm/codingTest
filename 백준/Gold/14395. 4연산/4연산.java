import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    HashSet<Integer> visitSet = new HashSet<>();
    Queue<State> bfs = new ArrayDeque<>();
    ArrayList<String> answerList = new ArrayList<>();
    if (s == t) {
      answerList.add("0");
    } else {
      bfs.offer(new State(s, new StringBuilder()));
    }

    int minLength = Integer.MAX_VALUE;
    while (bfs.size() > 0) {
      State state = bfs.poll();
      if (state.sb.length() < minLength) {
        long nextNum = (long) state.num * (long) state.num;
        if (nextNum <= 1_000_000_000 && !visitSet.contains((int) nextNum)) {
          State nextState = new State((int) nextNum, new StringBuilder(state.sb).append('*'));
          if (nextNum == t) {
            answerList.add(nextState.sb.toString());
            minLength = nextState.sb.length();
          } else {
            bfs.offer(nextState);
          }
          visitSet.add((int) nextNum);
        }
        nextNum = state.num << 1;
        if (nextNum <= 1_000_000_000 && !visitSet.contains((int) nextNum)) {
          State nextState = new State((int) nextNum, new StringBuilder(state.sb).append('+'));
          if (nextNum == t) {
            answerList.add(nextState.sb.toString());
            minLength = nextState.sb.length();
          } else {
            bfs.offer(nextState);
          }
          visitSet.add((int) nextNum);
        }
        if (!visitSet.contains(1)) {
          State nextState = new State(1, new StringBuilder(state.sb).append('/'));
          if (1 == t) {
            answerList.add(nextState.sb.toString());
            minLength = nextState.sb.length();
          } else {
            bfs.offer(nextState);
          }
          visitSet.add(1);
        }
      }

    }

    if (answerList.size() == 0) {
      System.out.println(-1);
    } else {
      StringBuilder sb = new StringBuilder();
      for (String str : answerList) {
        sb.append(str).append("\n");
      }
      System.out.println(sb);
    }
    br.close();
  }

  static class State {
    int num;
    StringBuilder sb;

    State(int num, StringBuilder sb) {
      this.num = num;
      this.sb = sb;
    }
  }
}