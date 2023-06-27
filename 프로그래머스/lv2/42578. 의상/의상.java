import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, HashSet> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            HashSet<String> set = map.getOrDefault(cloth[1], new HashSet<String>());
            set.add(cloth[0]);
            map.put(cloth[1], set);
        }
        
        int answer = 1;
        String[] types = map.keySet().toArray(new String[map.size()]);
        for(String type : types){
            answer *= map.get(type).size() + 1;
        }
            
        return --answer;
    }
}