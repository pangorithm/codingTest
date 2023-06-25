class Solution {
    static int[] dp;
    public int solution(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        return fib(n);
    }
    
    int fib(int n){
        if(dp[n] != 0){
            return dp[n];
        } else if(n == 0){
            return 0;
        }
        dp[n] = (fib(n - 2) + fib(n - 1)) % 1234567;
        return dp[n];
    }
}