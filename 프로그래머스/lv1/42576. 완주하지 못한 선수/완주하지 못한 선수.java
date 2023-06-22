import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : completion){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);                
            } else {
                map.put(str, 1);
                // System.out.println(str);
            }
        }
        
        for(String str : participant){
            if(map.containsKey(str)){
                if(map.get(str) > 0){
                    map.put(str, map.get(str) - 1);
                // System.out.println(str);
                } else {
                    return str;
                }
            } else {
                return str;
            }
        }
        return "";
    }
}