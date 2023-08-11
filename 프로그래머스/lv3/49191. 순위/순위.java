import java.util.*;

class Solution {
    static int[][] resultBoard;
    
    public int solution(int n, int[][] results) {
        resultBoard = new int[n + 1][n + 1];
        
        for(int[] r : results){
            resultBoard[r[0]][r[1]] = r[0];
            resultBoard[r[1]][r[0]] = r[0];
        }
        
        // 플루이드 워셜 전
        // for(int[] r : resultBoard){
        //     System.out.println(Arrays.toString(r));
        // }        
        // System.out.println("");
        
        for(int k = 1; k<= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j<=n; j++){
                    if(resultBoard[i][k] == i && resultBoard[k][j] == k){
                        resultBoard[i][j] = i;
                        resultBoard[j][i] = i;
                    }                    
                }
            }
        }
        
        // 플루이드 워셜 후
        // for(int[] r : resultBoard){
        //     System.out.println(Arrays.toString(r));
        // }
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int count = 1;
            for(int j = 1; j <= n; j++){
                if(resultBoard[i][j] > 0){
                    count++;
                }
            }
            if(count == n){
                answer++;
            }
        }
        return answer;
    }
}