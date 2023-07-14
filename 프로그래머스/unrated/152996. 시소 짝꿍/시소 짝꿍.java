import java.util.*;
class Solution {
    public long solution(int[] weights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < weights.length; i++){
            // 2/4 2/3 3/4 3/2 4/3 4/2 1/1
            // 6   8   9   18  16  24  12
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }
        long answer = 0;
        for(Integer weight : map.keySet().toArray(new Integer[0])){
            map.put(weight * 12, map.get(weight));
            map.remove(weight);
        }
        for(Integer weight : map.keySet()){
            answer += (long) map.get(weight) * (map.getOrDefault(weight / 4 * 2, 0)
                                        + map.getOrDefault(weight / 4 * 3, 0)
                                        + map.getOrDefault(weight / 3 * 2, 0)
                                        + map.getOrDefault(weight / 3 * 4, 0)
                                        + map.getOrDefault(weight / 2 * 3, 0)
                                        + map.getOrDefault(weight / 2 * 4, 0)
                                        + map.get(weight) - 1);
        }
        return answer / 2;
    }
}