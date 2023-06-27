import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, HashSet> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            if(map.containsKey(cloth[1])){
                map.get(cloth[1]).add(cloth[0]);
            } else {
                map.put(cloth[1], new HashSet<String>());
                map.get(cloth[1]).add(cloth[0]);
            }
        }
        
        int answer = 1;
        String[] types = map.keySet().toArray(new String[map.size()]);
        for(String type : types){
            answer *= map.get(type).size() + 1;
        }
            
        return --answer;
    }
}