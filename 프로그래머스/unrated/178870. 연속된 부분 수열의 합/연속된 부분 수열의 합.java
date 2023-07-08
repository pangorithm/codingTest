import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {         
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int minLength = sequence.length;
        
        int[] answer = new int[2];
        while(end < sequence.length){
            if(sum == k){
                int length = end - start;
                if(minLength > length){
                    minLength = length;
                    answer[0] = start;
                    answer[1] = end;
                }                
                sum -= sequence[start];
                start++;
                end++;
                if(end < sequence.length){
                    sum += sequence[end];
                }
            } else if (sum < k){
                if(end + 1 >= sequence.length){
                    break;
                }
                if(k - sum < sequence[end + 1]){
                    sum -= sequence[start];
                    start++;
                }
                end++;
                sum += sequence[end];
            } else { // sum > k
                sum -= sequence[start];
                start++;
                if(start >= sequence.length){
                    break;
                }
            }
        }
        return answer;
    }
}