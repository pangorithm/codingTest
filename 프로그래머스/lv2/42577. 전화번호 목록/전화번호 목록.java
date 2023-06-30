import java.util.HashMap;

class Solution {
    static boolean answer = true;
    
    public boolean solution(String[] phone_book) {
        HashMap<Character, HashMap> map = new HashMap<>();
        
        for(String str : phone_book){
            nextMap(str, map);
            if(answer == false){
                break;
            }
        }
        
        // System.out.println(map);
        return answer;
    }
    
    HashMap<Character, HashMap> nextMap(String str, HashMap<Character, HashMap> map){
        if(map.containsKey('z')){
            // System.out.println("false");
            answer = false;
            return map;
        }
        if(str.length() == 0){
            if(map.size() > 0){
                answer = false;
            }
            map.put('z', new HashMap<Character, HashMap>());
            return map;
        }
        char key = str.charAt(0);
        if(map.containsKey(key)){
            map.put(key, nextMap(str.substring(1), map.get(key)));
        } else {
            map.put(key, nextMap(str.substring(1), new HashMap<Character, HashMap>()));
        }
        return map;
    }
}