import java.util.*;

class Solution {
    static ArrayList<Integer>[] loadList;
    static int[] dp;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        loadList = new ArrayList[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[destination] = 0;
        
        for(int[] r : roads){
            if(loadList[r[0]] == null){
                loadList[r[0]] = new ArrayList<Integer>();
            }
            ArrayList<Integer> list = loadList[r[0]];
            list.add(r[1]);
            
            if(loadList[r[1]] == null){
                loadList[r[1]] = new ArrayList<Integer>();
            }
            list = loadList[r[1]];
            list.add(r[0]);
        }
        
        Queue<State> bfs = new ArrayDeque<State>();
        bfs.offer(new State(destination, 1));
        
        while(bfs.size() > 0){
            State state = bfs.poll();
            
            if(loadList[state.loc] != null){
                ArrayList<Integer> list = loadList[state.loc];
                int length = list.size();
                for(int i = 0; i < length; i++){
                    if(dp[list.get(i)] > state.dst && state.dst < n){
                        dp[list.get(i)] = state.dst;
                        bfs.offer(new State(list.get(i), state.dst + 1));
                    }
                }
            }            
        }
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            answer[i] = dp[sources[i]] == Integer.MAX_VALUE ? -1 : dp[sources[i]];
        }        
        
        return answer;
    }
    
    class State{
        int loc;
        int dst;
        
        State(int loc, int dst){
            this.loc = loc;
            this.dst = dst;
        }
    }
}