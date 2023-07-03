import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        boolean[][] dp = new boolean[maps.length][maps[0].length];
        int answer = Integer.MAX_VALUE;
                
        Queue<State> bfs = new LinkedList<>();
        bfs.offer(new State(0, 0, 1));
        
        while(bfs.size() != 0){
            State state = bfs.poll();
                        
            if(state.y == (maps.length - 1) && state.x == (maps[0].length - 1)){
                if(state.step < answer){
                    answer = state.step;
                    System.out.println(answer);
                }
            }
            
            for(State nextState : getNextStates(state, maps, dp)){
                if(nextState != null){
                    bfs.offer(nextState);
                }
            }                  
        }
        
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    class State {
        int y;
        int x;
        int step;
        
        State(int y, int x, int step){
            this.y = y;
            this.x = x;
            this.step = step;
        }
                
    }
    State[] getNextStates (State state, int[][] maps, boolean[][] dp){
        State[] nextStates = new State[4];
        if(state.x != (maps[0].length - 1) 
           && maps[state.y][state.x + 1] != 0
           && dp[state.y][state.x + 1] != true){
            nextStates[0] = new State(state.y, state.x + 1, state.step + 1);
            dp[state.y][state.x + 1] = true;
        }
            
        if(state.x != 0 
           && maps[state.y][state.x - 1] != 0
           && dp[state.y][state.x - 1] != true){
            nextStates[1] = new State(state.y, state.x - 1, state.step + 1);
            dp[state.y][state.x - 1] = true;
        }
            
        if(state.y != (maps.length - 1) 
           && maps[state.y + 1][state.x] != 0
           && dp[state.y + 1][state.x] != true){
            nextStates[2] = new State(state.y + 1, state.x, state.step + 1);
            dp[state.y + 1][state.x] = true;
        }
            
        if(state.y != 0 
           && maps[state.y - 1][state.x] != 0
           && dp[state.y - 1][state.x] != true){
            nextStates[3] = new State(state.y - 1, state.x, state.step + 1);
            dp[state.y - 1][state.x] = true;
        }
            
        return nextStates;
    }
}