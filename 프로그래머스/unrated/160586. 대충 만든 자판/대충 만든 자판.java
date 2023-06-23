import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(String str : keymap){
            char[] carr = str.toCharArray();
            for(int i = 0; i < carr.length; i++){
                if(map.containsKey(carr[i])){
                    if(map.get(carr[i]) > i + 1){
                        map.put(carr[i], i + 1);
                    }
                } else {
                    map.put(carr[i], i + 1);                    
                }
            }
        }
        
        for(int i = 0; i < answer.length; i++){
            char[] carr = targets[i].toCharArray();
            for(int j = 0; j < carr.length; j++){
                if(map.containsKey(carr[j])){
                    answer[i] += map.get(carr[j]);
                    // System.out.println(carr[j]+ ":" + map.get(carr[j]));
                } else {
                    answer[i] = -1;    
                    break;
                }
            }
        }
        
        return answer;
    }
}