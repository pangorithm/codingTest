import java.util.*;

class Solution {
    static Map<Integer, Integer> map;
    
    public int solution(int N, int number) {
        map = initMap(N);
        dfs(N, 0, 0);
        return map.getOrDefault(number, -1);
    }

    private void dfs(int N, int cnt, int current) {
        if (cnt > 8) {
            return;
        }

        map.put(current, Math.min(map.getOrDefault(current, cnt), cnt));
        
        int number = N;
        for(int i = 1; i <= 8; i++){
            dfs(N, cnt + i, current + number);
            dfs(N, cnt + i, current - number);
            dfs(N, cnt + i, current * number);
            dfs(N, cnt + i, current / number);            
            number = number * 10 + N;
        }
    }

    private Map<Integer, Integer> initMap(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        int number = N;
        for (int i = 1; i <= 8; i++) {
            map.put(number, i);
            number = number * 10 + N;
        }

        return map;
    }
}