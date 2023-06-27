import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int[] citations) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        HashSet<Integer> set = new HashSet<>(); 
        // (인용 횟수: key이상 인용된 논문 수)
        for(int ref : citations){
            if(set.contains(ref)){
                continue;
            } else {
                set.add(ref);
                for(int temp : citations){
                    if(ref <= temp){
                        map.put(ref, map.getOrDefault(ref, 0) + 1);
                    }
                }
            }
            int h = Math.min(ref, map.get(ref));
            if(h > max){
                max = h;
            }
        }
        return max;
    }
}