import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String lastTime = String.format("%02d:%02d", 9 + ((n - 1) * t) / 60, ((n - 1) * t) % 60);        
        String answer = lastTime;
        
        ArrayList<String> timeList = new ArrayList<>(Arrays.asList(timetable));
        Collections.sort(timeList);
        
        for(int i = 0; i < n; i++){
            int count = 0;
            String busTime = String.format("%02d:%02d", 9 + (i * t) / 60, (i * t) % 60);
            // System.out.println(busTime);
            
            while(timeList.size() > 0){
                if(timeList.get(0).compareTo(busTime) > 0){
                    break;
                }
                // System.out.println(timeList.get(0)+" "+timeMap.get(timeList.get(0)));
                
                count ++;
                
                if(i == n - 1 && count >= m){
                    String[] hnm = timeList.get(0).split(":");
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
                    timeList.remove(0);
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}