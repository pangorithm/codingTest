import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static State targetState;

  public static void main(String[] args) throws IOException {

    String stickA = "";
    StringTokenizer st = new StringTokenizer(br.readLine());
    st.nextToken();
    if (st.hasMoreTokens()) {
      stickA = st.nextToken();
    }

    String stickB = "";
    st = new StringTokenizer(br.readLine());
    st.nextToken();
    if (st.hasMoreTokens()) {
      stickB = st.nextToken();
    }

    String stickC = "";
    st = new StringTokenizer(br.readLine());
    st.nextToken();
    if (st.hasMoreTokens()) {
      stickC = st.nextToken();
    }

    int[] counts = new int[3];
    count(stickA, counts);
    count(stickB, counts);
    count(stickC, counts);
    targetState = new State(
        "A".repeat(counts[0]),
        "B".repeat(counts[1]),
        "C".repeat(counts[2]),
        0);
    // System.out.println(targetState);

    HashMap<State, Integer> stateDpMap = new HashMap<>();

    ArrayDeque<State> bfs = new ArrayDeque<>();
    State iniState = new State(stickA, stickB, stickC, 0);
    stateDpMap.put(iniState, 0);
    if (!iniState.equals(targetState)) {
      bfs.offer(iniState);
    }
    while (!bfs.isEmpty()) {
      State state = bfs.poll();
      state.count++;

      if (state.stickA.length() > 0) {
        String nextStickA = state.stickA.substring(0, state.stickA.length() - 1);
        String particleString = state.stickA.substring(state.stickA.length() - 1);
        State nextState = new State(nextStickA, state.stickB + particleString, state.stickC, state.count);
        if (stateDpMap.getOrDefault(nextState, Integer.MAX_VALUE) > nextState.count) {
          stateDpMap.put(nextState, nextState.count);
          if (nextState.equals(state)) {
            break;
          }
          bfs.offer(nextState);
        }

        nextState = new State(nextStickA, state.stickB, state.stickC + particleString, state.count);
        if (stateDpMap.getOrDefault(nextState, Integer.MAX_VALUE) > nextState.count) {
          stateDpMap.put(nextState, nextState.count);
          if (nextState.equals(state)) {
            break;
          }
          bfs.offer(nextState);
        }

      }

      if (state.stickB.length() > 0) {
        String nextStickB = state.stickB.substring(0, state.stickB.length() - 1);
        String particleString = state.stickB.substring(state.stickB.length() - 1);
        State nextState = new State(state.stickA + particleString, nextStickB, state.stickC, state.count);
        if (stateDpMap.getOrDefault(nextState, Integer.MAX_VALUE) > nextState.count) {
          stateDpMap.put(nextState, nextState.count);
          if (nextState.equals(state)) {
            break;
          }
          bfs.offer(nextState);
        }

        nextState = new State(state.stickA, nextStickB, state.stickC + particleString, state.count);
        if (stateDpMap.getOrDefault(nextState, Integer.MAX_VALUE) > nextState.count) {
          stateDpMap.put(nextState, nextState.count);
          if (nextState.equals(state)) {
            break;
          }
          bfs.offer(nextState);
        }
      }

      if (state.stickC.length() > 0) {
        String nextStickC = state.stickC.substring(0, state.stickC.length() - 1);
        String particleString = state.stickC.substring(state.stickC.length() - 1);
        State nextState = new State(state.stickA + particleString, state.stickB, nextStickC, state.count);
        if (stateDpMap.getOrDefault(nextState, Integer.MAX_VALUE) > nextState.count) {
          stateDpMap.put(nextState, nextState.count);
          if (nextState.equals(state)) {
            break;
          }
          bfs.offer(nextState);
        }

        nextState = new State(state.stickA, state.stickB + particleString, nextStickC, state.count);
        if (stateDpMap.getOrDefault(nextState, Integer.MAX_VALUE) > nextState.count) {
          stateDpMap.put(nextState, nextState.count);
          if (nextState.equals(state)) {
            break;
          }
          bfs.offer(nextState);
        }
      }

    }

    // System.out.println(stateDpMap);
    System.out.println(stateDpMap.get(targetState));
    br.close();
  }

  static void count(String str, int[] counts) {
    for (char ch : str.toCharArray()) {
      switch (ch) {
        case 'A':
          counts[0]++;
          break;
        case 'B':
          counts[1]++;
          break;
        case 'C':
          counts[2]++;
          break;
      }
    }
  }

  static class State {
    String stickA;
    String stickB;
    String stickC;
    int count;

    State(String stickA, String stickB, String stickC, int count) {
      this.stickA = stickA;
      this.stickB = stickB;
      this.stickC = stickC;
      this.count = count;
    }

    @Override
    public String toString() {
      return stickA + " " + stickB + " " + stickC;
    }

    @Override
    public int hashCode() {
      return Objects.hash(stickA, stickB, stickC);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof State) {
        State s = (State) obj;
        return s.stickA.equals(this.stickA) && s.stickB.equals(this.stickB) && s.stickC.equals(this.stickC);
      }
      return false;
    }
  }
}
