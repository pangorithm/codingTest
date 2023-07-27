import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                answer++;
                visitNet(computers, i, n);
                visited[i] = true;
            }
        }
        return answer;
    }
    
    void visitNet(int[][] computers, int index, int n){
        visited[index] = true;
        for(int i = 0; i < n; i++){
            if(computers[index][i] == 1 && !visited[i]){
                visitNet(computers, i, n);
            }
        }
    }
}