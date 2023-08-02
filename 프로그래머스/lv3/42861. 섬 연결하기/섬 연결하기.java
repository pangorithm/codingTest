import java.util.*;

class Solution {    
    static int[][] matrix;
    
    public int solution(int n, int[][] costs) {
        matrix = new int[n][n];
        Arrays.sort(costs, (n1, n2) -> n1[2] - n2[2]);
        HashMap<Integer, Boolean> vMap = new HashMap<>();
        int answer = 0;
        for(int[] c : costs){
            // System.out.println(Arrays.toString(c));
            if(!isLinked(c[0], c[1])){
                // System.out.println(vMap.getOrDefault(c[0], false) +" "+ vMap.getOrDefault(c[1], false));
                matrix[c[0]][c[1]] = c[2];
                matrix[c[1]][c[0]] = c[2];
                answer += c[2];
            }
        }
        
        return answer;
    }
    
    boolean isLinked(int n1, int n2){
        boolean[] visited = new boolean[matrix.length];
        Queue<Integer> bfs = new ArrayDeque<>();
        bfs.offer(n1);
        while(bfs.size() > 0){
            int node = bfs.poll();
            
            for(int i = 0; i < matrix[node].length; i++){
                if(visited[i] == false && matrix[node][i] > 0){
                    if(i == n2){
                        return true;
                    }
                    visited[i] = true;
                    bfs.offer(i);
                }
            }
        }
        return false;
    }
}