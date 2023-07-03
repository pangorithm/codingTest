import java.util.TreeMap;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        TreeMap<Integer, HashSet> map = new TreeMap<>(); // <가격, 인덱스>
        
        for(int i = 0; i < prices.length; i++){
            // HashSet set;
            // if(map.containsKey(prices[i])){
            //     set = map.get(prices[i]);
            // } else {
            //     set = new HashSet<Integer>();
            // }
            HashSet set = map.getOrDefault(prices[i], new HashSet<Integer>());
            set.add(i);
            map.put(prices[i], set);
            answer[i] = prices.length - 1 - i;
            
            for(int lastKey = map.lastKey(); lastKey > prices[i]; lastKey = map.lastKey()){
                Integer[] arr = new Integer[map.get(lastKey).size()];
                map.get(lastKey).toArray(arr);
                for(Integer index : arr){
                    answer[index] = i - index;
                }
                map.remove(lastKey);                
            }
        }
        
        return answer;
    }
}