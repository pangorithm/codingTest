import java.util.*;

class Solution {
    static int[][] floyd;
    static final int MAX = Integer.MAX_VALUE >> 5;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        floyd = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n ; j++){
                floyd[i][j] = i == j ? 0 : MAX;
            }
        }     
        
        for(int[] fare : fares){
            floyd[fare[0]][fare[1]] = fare[2];
            floyd[fare[1]][fare[0]] = fare[2];
        }
        
        for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(floyd[i][k] + floyd[k][j] < floyd[i][j]) {
						floyd[i][j] = floyd[i][k] + floyd[k][j];
					}
				}
			}
		}
        
        int answer = MAX;
        
        for(int i = 1; i <= n; i++){
            int cost = floyd[i][s] + floyd[i][a] + floyd[i][b];
            if(answer > cost){
                answer = cost;
            }
        }
        
        return answer;
    }
}