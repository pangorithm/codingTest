import java.util.TreeMap;

class Solution {
    public int solution(int[] scoville, int K) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int answer = 0;
        for(int food : scoville){
            map.put(food, map.getOrDefault(food, 0) + 1);
        }
        int firstKey = map.firstKey();
        int m0 = 0;
        int m1 = 0;
        
        while(firstKey < K){
            answer++;
            m0 = firstKey;
            map.put(firstKey, map.get(firstKey) - 1);
            if(map.get(firstKey) == 0){
                map.remove(firstKey);
                if(map.size() == 0){
                    return -1;
                }
                firstKey = map.firstKey();
            }
            
            m1 = firstKey;
            map.put(firstKey, map.get(firstKey) - 1);
            int mix = m0 + m1 * 2;
            map.put(mix, map.getOrDefault(mix, 0) + 1);
            
            if(map.get(firstKey) == 0){
                map.remove(firstKey);
                if(map.size() == 0){
                    if(mix < K){
                        return -1;
                    } else {
                        return answer;
                    }
                }
                firstKey = map.firstKey();
            }
        }
        
        return answer;
    }
}