class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n][m];
        for(int[] puddle : puddles){
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        for(int y = 0; y < n; y++){
            for(int x = 0; x < m; x++){
                if(dp[y][x] == -1){
                    dp[y][x] = 0;
                } else if(y == 0 && x == 0){
                    dp[0][0] = 1;
                }else if(y == 0){
                    dp[0][x] = dp[0][x - 1];
                } else if(x == 0){
                    dp[y][0] = dp[y - 1][0];
                } else {
                    dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % 1_000_000_007;
                }                
            }
        }
        return dp[n - 1][m - 1];
    }
}