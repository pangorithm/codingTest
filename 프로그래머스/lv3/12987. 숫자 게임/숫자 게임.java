import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int i = A.length - 1, j = B.length - 1;
        while (i >= 0) {
            if(A[i] < B[j]) {
                answer++;
                j--;
            } 
            i--;
        }
            
        return answer;
    }
}