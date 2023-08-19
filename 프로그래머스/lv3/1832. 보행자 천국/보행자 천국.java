class Solution {
    int MOD = 20170805;
    static int[][] dp;
    
    public int solution(int m, int n, int[][] cityMap) {
        dp = new int[m][n];
        
        dp[0][0] = 1;
        for(int i = 1; i < m; i++){
            if(cityMap[i][0] == 0){
                dp[i][0] = 1;
            } else if(cityMap[i][0] == 1){
                break;
            } else if(cityMap[i][0] == 2){
                continue;
            }
        }
        for(int i = 1; i < n; i++){
            if(cityMap[0][i] == 0){
                dp[0][i] = 1;
            } else if(cityMap[0][i] == 1){
                break;
            } else if(cityMap[0][i] == 2){
                continue;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(cityMap[i][j] == 0){
                    int preI = i - 1;
                    while(dp[preI][j] == -1){
                        preI--;
                    }
                    int preJ = j - 1;
                    while(dp[i][preJ] == -1){
                        preJ--;
                    }
                    dp[i][j] = (dp[preI][j] + dp[i][preJ]) % MOD;
                } else if(cityMap[i][j] == 1){
                    continue;
                } else if(cityMap[i][j] == 2){
                    dp[i][j] = -1;
                }
            }
        }
            
        return dp[m - 1][n - 1];
    }
}