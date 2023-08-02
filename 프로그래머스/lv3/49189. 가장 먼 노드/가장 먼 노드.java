import java.util.*;

class Solution {
    static boolean[][] matrix;
    static int[] route;
    
    public int solution(int n, int[][] edge) {
        matrix = new boolean[n][n];
        for(int[] e : edge){
            matrix[e[0] - 1][e[1] - 1] = true;
            matrix[e[1] - 1][e[0] - 1] = true;
        }        
        route = new int[n];
        Arrays.fill(route, Integer.MAX_VALUE);
        route[0] = 0;
                
        Queue<State> bfs = new ArrayDeque<>();
        bfs.offer(new State(0, 0));
        while(bfs.size() > 0){
            State state = bfs.poll();
            
            for(int i = 0; i < n; i++){
                if(matrix[state.node][i]){
                    if(route[i] > state.dept + 1){
                        route[i] = state.dept + 1;
                        bfs.offer(new State(i, state.dept + 1));
                    }
                }
            }            
        }
        // System.out.println(Arrays.toString(route));
        
        int max = 0;
        int answer = 0;
        for(int r : route){
            if(max < r){
                max = r;
                answer = 1;
            } else if(max == r){
                answer++;
            }
        }
        
        return answer;
    }
    
    class State {
        int node;
        int dept;
        
        State(int node, int dept){
            this.node = node;
            this.dept = dept;
        }
    }
}