import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
            
        int index = 0;
        while(index < 26){
            map.put(Character.toString((char) ('A' + index++)), index);
        }
        // System.out.println(map);
        int strLength = msg.length();
        loop : for(int i = 0; i < strLength;){
            int length = 1;
            
            String substr = msg.substring(i, i + length);
            
            if(i + length == strLength){
                list.add(map.get(substr));
                break;
            }
            String nextSubstr = msg.substring(i, i + length + 1);
            while(set.contains(nextSubstr)){
                substr = nextSubstr;
                if(i + length + 2 > strLength){
                    list.add(map.get(substr));
                    break loop;
                }
                nextSubstr = msg.substring(i, i + ++length + 1);
            }
            set.add(nextSubstr);
            list.add(map.get(substr));
            // System.out.println((substr));
            map.put(nextSubstr, ++index);
            i += length;
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}