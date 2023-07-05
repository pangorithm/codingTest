import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> leftSet = new HashSet<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for(int i = 0; i < topping.length; i++){                
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }
        for(int i = 0; i < topping.length; i++){        
            leftSet.add(topping[i]); 
            if(rightMap.containsKey(topping[i])){ 
                int toppingCount = rightMap.get(topping[i]);
                if(toppingCount == 1){
                    rightMap.remove(topping[i]);
                } else {
                    rightMap.put(topping[i], toppingCount - 1);
                }
            }
            if(leftSet.size() == rightMap.size()){
                answer++;
            }
        }
        return answer;
    }
}