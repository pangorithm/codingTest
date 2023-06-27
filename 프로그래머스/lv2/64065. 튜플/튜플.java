import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String s) {
        String[] strs = s.replaceAll("[^0-9,]","").split(","); 
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : strs){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        int[] answer = new int[map.size()];
        String[] arr = map.keySet().toArray(new String[answer.length]);
        for(String str : arr){
            answer[arr.length - map.get(str)] = Integer.parseInt(str);
        }
            
        return answer;
    }
}