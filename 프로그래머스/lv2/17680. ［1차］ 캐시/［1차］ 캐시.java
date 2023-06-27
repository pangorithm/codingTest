import java.util.HashMap;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            int ru = map.getOrDefault(city, -1);
            if(ru != -1){
                answer += 1;
                map.put(city, i);
                continue;
            }
            answer += 5;
            map.put(city, i);
            
            while(map.size() > cacheSize){
                int count = 0;
                int min = i;
                int index = i;
                while(count != cacheSize + 1){
                    if(map.containsValue(index)){
                        min = index;
                        count++;
                    }
                    index--;
                }
                map.remove(cities[min].toLowerCase());
            }
        }
        return answer;
    }
}