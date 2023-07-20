import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (v1, v2) -> v1[1] - v2[1]);
        int answer = 0;
        int cursor = 0;
        
        for(int[] target : targets){
            if(target[0] < cursor){
                continue;
            } else {
                cursor = target[1];
                answer++;
            }
        }
                
        return answer;
    }
}