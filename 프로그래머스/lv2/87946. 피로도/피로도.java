import java.util.Stack;
import java.util.HashSet;

class Solution {
    static int[][] data;
    public int solution(int k, int[][] dungeons) {
        data = dungeons;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < dungeons.length; i++){
            set.add(i);
        }
        
        int max = 0;
        HashSet<Integer> canVisit = new HashSet<>();
        for(int i = 0; i < dungeons.length; i++){
            if(k >= dungeons[i][0]){
                canVisit.add(i);
            }
        }
        
        Stack<State> dfs = new Stack<>();
        dfs.add(new State(canVisit, k, 0));
        while(!dfs.empty()){
            State state = dfs.pop();
            if(state.canVisit.size() == 0){
                if(max < state.count){
                    max = state.count;
                    if(max == dungeons.length){
                        return max;
                    }
                }
            } else {
                for(State next : getNextState(state)){
                    dfs.push(next);
                }
            }
        }
        
        return max;
    }
    
    private static class State {
        public HashSet<Integer> canVisit;
        public int point;
        public int count;
        
        State(HashSet<Integer> canVisit, int point, int count){
            this.canVisit = new HashSet<Integer>(canVisit);
            this.point = point;
            this.count = count;
        }
    }
    
    private State[] getNextState(State state){
        State[] nextStates = new State[state.canVisit.size()];
        Integer[] list = state.canVisit.toArray(new Integer[state.canVisit.size()]);
        for(int i = 0; i < nextStates.length; i++){
            HashSet<Integer> temp = new HashSet<>(state.canVisit);
            temp.remove(list[i]);
            int nextPoint = state.point - data[list[i]][1];
            for(Integer num : list){
                if(data[num][0] > nextPoint){
                    temp.remove(num);
                }
            }
            nextStates[i] = new State(temp, nextPoint, state.count + 1);
        }
        return nextStates;
    }
    
}