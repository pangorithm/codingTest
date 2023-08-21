import java.util.*;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int[] dumpWeak = new int[weak.length << 1];
        for(int i = 0; i < weak.length; i++){
            dumpWeak[i] = weak[i];
            dumpWeak[i + weak.length] = weak[i] + n;
        }
        
        Integer[] sortedDist = new Integer[dist.length];
        for(int i = 0; i < dist.length; i++){
            sortedDist[i] = dist[i];
        }
        Arrays.sort(sortedDist, (v1, v2) -> v2 - v1);
        
        Queue<State> bfs = new ArrayDeque<>();
        bfs.offer(new State(new boolean[weak.length], 0));
        
        while(bfs.size() > 0){
            State state = bfs.poll();

            for(int i = 0; i < weak.length; i++){
                if(!state.weakState[i]){
                    boolean[] nextWeakState = Arrays.copyOf(state.weakState, weak.length);
                    for(int j = i; dumpWeak[j] <= weak[i] + sortedDist[state.dept]; j++){
                        nextWeakState[j % weak.length] = true;
                    }
                                    
                    boolean checkedAll = true;
                    for(boolean b : nextWeakState){
                        if(!b){
                            checkedAll = false;
                            break;
                        }
                    }
                    if(checkedAll){
                        return state.dept + 1;
                    } 
                        
                    if(state.dept + 1 < dist.length){
                        bfs.offer(new State(nextWeakState, state.dept + 1));
                    }
                }
            }
        }
        
        return -1;
    }
    
    class State{
        boolean[] weakState;
        int dept;
        
        State(boolean[] weakState, int dept){
            this.weakState = weakState;
            this.dept = dept;
        }
    }
}