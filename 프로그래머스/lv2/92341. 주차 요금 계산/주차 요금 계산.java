import java.util.TreeMap;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int count = 0;
        TreeMap<String, Integer> recMap = new TreeMap<>();
        
        for(String str : records){
            String[] arr = str.split(" ");
            String[] time = arr[0].split(":");
            if(arr[2].equals("IN")){
                recMap.put(arr[1], 
                           recMap.getOrDefault(arr[1], 0)
                           - (Integer.parseInt(time[0]) * 60 
                           + Integer.parseInt(time[1]))
                          );
            } else {
                recMap.put(arr[1],
                           recMap.get(arr[1])
                           + (Integer.parseInt(time[0]) * 60 
                           + Integer.parseInt(time[1]))
                          );
            }
        }
        
        for(String rec : recMap.keySet()
            .toArray(new String[recMap.size()])){
            int time = recMap.get(rec);
            if(time <= 0){
                recMap.put(rec, time + 23 * 60 + 59);
            }
        }
        
        String[] cars = recMap.keySet()
            .toArray(new String[recMap.size()]);
        int[] answer = new int[cars.length];
        for(int i = 0; i < cars.length; i++){
            int useTime = recMap.get(cars[i]);
            if(useTime > fees[0]) {
                answer[i] = fees[1] 
                    + ((useTime - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
            } else {
                answer[i] = fees[1];
            }
        }
        
        return answer;
    }
}