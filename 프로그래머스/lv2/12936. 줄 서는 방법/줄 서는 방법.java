import java.util.*;

class Solution {
    long[] dp;
    
    public int[] solution(int n, long k) {
        dp = new long[n];
        dp[0] = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        
        int[] answer = new int[n];
        
        int index = 0;
        while(index < n){
            answer[index] = list.remove((int) ((k - 1) / fac(n - index - 1)));
            k -= ((k - 1) / fac(n - index - 1)) * fac(n - index - 1);
            index++;
        }
        
        return answer;
    }
    
    long fac (int n){
        if(dp[n] != 0){
            return dp[n];
        }
        
        dp[n] = n * fac(n - 1);
        return dp[n];
    }
}