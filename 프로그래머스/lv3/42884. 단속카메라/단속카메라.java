import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (v1, v2) -> v1[1] - v2[1]);
        int answer = 1;
        
        int camera = routes[0][1];
        for(int[] route : routes){
            if(route[0] > camera){
                answer++;
                camera = route[1];
            }
        }
        
        return answer;
    }
}