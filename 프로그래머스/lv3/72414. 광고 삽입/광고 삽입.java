import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int playTime = stringTimeToInt(play_time);
        int advTime = stringTimeToInt(adv_time);
        
        long[] timeLine = new long[playTime + 2];
        
        for(int i = 0; i < logs.length; i++){
            String[] temp = logs[i].split("-");
            timeLine[stringTimeToInt(temp[0])]++;
            timeLine[stringTimeToInt(temp[1])]--;
        }
        
        for(int i = 1; i <= playTime; i++){
            timeLine[i] += timeLine[i - 1];
        }
        
        for(int i = 1; i <= playTime; i++){
            timeLine[i] += timeLine[i - 1];
        }
        
        int answerTime = 0;
        long answerResult = timeLine[advTime - 1];
        for(int i = advTime; i < playTime; i++){
            long result = timeLine[i] - timeLine[i - advTime];
            if(answerResult < result){
                answerResult = result;
                answerTime = i - advTime + 1;
            }
        }
        
        return intTimeToString(answerTime);
    }
    
    int stringTimeToInt(String t){
        String[] time = t.split(":");
        return Integer.parseInt(time[0]) * 60 * 60
                + Integer.parseInt(time[1]) * 60
                + Integer.parseInt(time[2]);
    }
    
    String intTimeToString(int t){
        int s = t % 60;
        t/= 60;
        int m = t % 60;
        t/= 60;
        int h = t;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}