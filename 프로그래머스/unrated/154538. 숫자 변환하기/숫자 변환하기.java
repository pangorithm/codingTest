import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<State> bfs = new LinkedList<>();
        if(x == y){
            return 0;
        }
        bfs.offer(new State(y, 0));
        while(bfs.size() > 0){
            State state = bfs.poll();
            if(state.num == x){
                return state.step;
            } else if(state.num > x){
                for(State nextState : getNextStates(state, n)){
                    if(nextState != null){
                        bfs.offer(nextState);
                    }
                }
            }
        }
        return -1;
    }
    
    class State {
        int num;
        int step;
        
        State(int num, int step){
            this.num = num;
            this.step = step;
        }
    }
    
    State[] getNextStates(State state, int n){
        State[] nextStates = new State[3];
        if((state.num >> 1) >= n){
            nextStates[0] = (state.num % 3) == 0 ? new State(state.num / 3, state.step + 1) : null;
            nextStates[1] = (state.num & 1) == 0 ? new State(state.num >> 1, state.step + 1) : null;
            nextStates[2] = new State(state.num - n, state.step + 1);
        } else if((state.num >> 1) < n && n <= (state.num * 2 / 3)){            
            nextStates[0] = (state.num % 3) == 0 ? new State(state.num / 3, state.step + 1) : null;
            nextStates[1] = (state.num & 1) == 0 ? new State(state.num - n, state.step + 1) : null;
            nextStates[2] = new State(state.num >> 1, state.step + 1);
        } else {            
            nextStates[0] = new State(state.num - n, state.step + 1);
            nextStates[1] = (state.num % 3) == 0 ? new State(state.num / 3, state.step + 1) : null;
            nextStates[2] = (state.num & 1) == 0 ? new State(state.num >> 1, state.step + 1) : null;
        }
        return nextStates;
    }
}