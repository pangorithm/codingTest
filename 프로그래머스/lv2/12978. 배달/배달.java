import java.util.*;

class Solution {    
    public int solution(int N, int[][] road, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for(int i = 0; i < N + 1; i++){
            Arrays.fill(graph[i], K + 1);
            graph[i][i] = 0;
        }
        
        for(int[] r : road){
            graph[r[0]][r[1]] = Math.min(graph[r[0]][r[1]], r[2]);
            graph[r[1]][r[0]] = Math.min(graph[r[1]][r[0]], r[2]);
        }
                
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<State> dfs = new Stack();
        
        dfs.push(new State(1, 0, new HashSet<Integer>(1)));
        while(dfs.size() > 0){
            if(map.size() == N){
                return N;
            }
            State state = dfs.pop();
                        
            map.put(state.num, state.time);
                
            for(int i = 1; i <= N; i++){
                if(state.num == i){
                    continue;
                }
                int nextTime = state.time + graph[state.num][i];
                
                if(!state.set.contains(i) && nextTime <= map.getOrDefault(i, K)){
                    HashSet<Integer> newSet = new HashSet<>(state.set);
                    newSet.add(i);
                    dfs.push(new State(i, nextTime, newSet));
                }
            }                       
        }
                
        return map.size();
    }
    
    class State {
        int num;
        int time;
        HashSet<Integer> set;
        
        State(int num, int time, HashSet<Integer> set){
            this.num = num;
            this.time = time;
            this.set = set;
        }
    }
}