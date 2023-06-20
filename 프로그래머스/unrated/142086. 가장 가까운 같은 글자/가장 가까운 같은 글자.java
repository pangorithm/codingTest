import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        char[] carr = s.toCharArray();
        int[] answer = new int[carr.length];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < carr.length; i++){
            if(!map.containsKey(carr[i])){
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(carr[i]);
            }
            map.put(carr[i], i);
        }
        return answer;
    }
}