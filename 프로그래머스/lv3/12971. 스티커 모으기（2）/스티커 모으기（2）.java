import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1){
            return sticker[0];
        } else if(sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        } else if(sticker.length == 3){
            return Math.max(Math.max(sticker[0], sticker[1]), sticker[2]);
        }
        
        return Math.max(getAnswer(0, sticker), getAnswer(1, sticker));
    }
    
    int getAnswer(int start, int sticker[]){
        int length;
        int[] dp = Arrays.copyOf(sticker, sticker.length);
        
        if(start == 0){
            length = sticker.length - 1;
            dp[2] += dp[0];
            for(int i = 3; i < length; i++){
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + dp[i];
            }
            return Math.max(dp[length - 1], dp[length - 2]);
        } else {
            length = sticker.length;
            dp[3] += dp[1];
            for(int i = 4; i < length; i++){
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + dp[i];
            }
            return Math.max(dp[length - 1], dp[length - 2]);
        }
    }
}