class Solution {
    public int solution(int n, int[] tops) {
        
        int n2 = n * 2;
        int[] dp = new int[n2 + 1];
        
        dp[0] = 1;
        dp[1] = tops[0] == 0 ? 2 : 3;
        
        for(int i = 1; i < n; i++){
            int index = i * 2;
            dp[index] = dp[index - 1] + dp[index - 2];
            dp[index] %= 10007;
            if(tops[i] == 0){
                dp[index + 1] = dp[index] + dp[index - 1];
            } else {
                dp[index + 1] = dp[index] * 2 + dp[index - 1];
            }
            dp[index + 1] %= 10007;
        }
        
        dp[n2] = dp[n2 - 2] + dp[n2 - 1];
        dp[n2] %= 10007;
        
        return dp[n2];
    }
}