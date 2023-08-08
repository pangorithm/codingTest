import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String lastTime = String.format("%02d:%02d", 9 + ((n - 1) * t) / 60, ((n - 1) * t) % 60);        
        String answer = lastTime;
        
        Arrays.sort(timetable);
        int cursor = 0;
        
        for(int i = 0; i < n; i++){
            int count = 0;
            String busTime = String.format("%02d:%02d", 9 + (i * t) / 60, (i * t) % 60);
            
            while(cursor < timetable.length){
                if(timetable[cursor].compareTo(busTime) > 0){
                    break;
                }                
                count ++;
                
                if(i == n - 1 && count >= m){
                    String[] hnm = timetable[cursor].split(":");
                    int hour = Integer.parseInt(hnm[0]);
                    int min = Integer.parseInt(hnm[1]) - 1;
                    if(min < 0){
                        hour--;
                        min += 60;
                    }
                    answer = String.format("%02d:%02d", hour, min);
                    break;
                }
                
                if(count <= m){
                    cursor++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}