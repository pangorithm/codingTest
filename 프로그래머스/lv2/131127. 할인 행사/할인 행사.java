import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> originMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            originMap.put(want[i], number[i]);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        loop : for(int day = 0; day < discount.length - 9; day++){
            for(String item : want){
                map.put(item, originMap.get(item));
            }
            
            for(int i = day; i < Math.min(day + 10, discount.length); i++){
                if(map.getOrDefault(discount[i], 0) > 0){
                    map.put(discount[i], map.get(discount[i]) - 1);
                }
            }
            
            for(String item : want){
                if(map.get(item) > 0){
                    continue loop;
                }
            }
            answer++;
        }
        
        return answer;
    }
}