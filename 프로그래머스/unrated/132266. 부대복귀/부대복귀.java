import java.util.*;

class Solution {
    static HashMap<Integer, ArrayList<Integer>> roadMap;
    static int[] dp;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        roadMap = new HashMap<Integer, ArrayList<Integer>>();
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[destination] = 0;
        
        for(int[] r : roads){
            ArrayList<Integer> list = roadMap.getOrDefault(r[0], new ArrayList<Integer>());
            list.add(r[1]);
            roadMap.put(r[0], list);
            
            list = roadMap.getOrDefault(r[1], new ArrayList<Integer>());
            list.add(r[0]);
            roadMap.put(r[1], list);
        }
        
        Queue<State> bfs = new ArrayDeque<State>();
        bfs.offer(new State(destination, 1));
        
        while(bfs.size() > 0){
            State state = bfs.poll();
            
            if(roadMap.containsKey(state.loc)){
                ArrayList<Integer> list = roadMap.get(state.loc);
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