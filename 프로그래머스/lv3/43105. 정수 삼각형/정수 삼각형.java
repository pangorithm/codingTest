import java.util.*;

class Solution {

    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int dept = 1; dept < triangle.length; dept++){
            triangle[dept][0] += triangle[dept - 1][0];
            for(int index = 1; index < triangle[dept].length - 1; index++){
                triangle[dept][index] += Math.max(triangle[dept - 1][index - 1], triangle[dept - 1][index]);
            }
            triangle[dept][triangle[dept].length - 1] += triangle[dept - 1][triangle[dept - 1].length - 1];
        }
        for(int i = 0; i < triangle[triangle.length - 1].length; i++){
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }
        
        return answer;
    }
}