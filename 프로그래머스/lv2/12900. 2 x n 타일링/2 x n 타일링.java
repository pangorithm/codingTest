class Solution {
    public int solution(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 3;
        }
        if(n == 4){
            return 5;
        }
        int[] dp = new int[3];
        dp[0] = 3;
        dp[1] = 5;
        for(int i = 5; i <= n; i++){
            dp[2] = (dp[0] + dp[1]) % 1000_000_007;
            dp[0] = dp[1];
            dp[1] = dp[2];
        // System.out.println(i + " : " + dp[2]);
        }
        return dp[2];
    }
}