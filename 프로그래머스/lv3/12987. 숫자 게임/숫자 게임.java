import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        for(int i = 0; i < B.length; i++){
            int count = 0;
            for(int j = 0; j + i < B.length; j++){
                if(A[j] < B[j + i]){
                    count++;
                }
            }
            if(count > answer){
                answer = count;
            } else if(count < answer){
                return answer;
            }
        }
            
        return answer;
    }
}