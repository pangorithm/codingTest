import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (v1, v2) -> {
            int temp = v1[col - 1] - v2[col - 1];
            if(temp == 0){
                return v2[0] - v1[0];
            } else {
                return temp;
            }
        });
        // for(int[] d : data){
        //     System.out.println(Arrays.toString(d));            
        // }
        int answer = 0;
        for(int c = 0; c < data[0].length; c++){
            answer += data[row_begin - 1][c] % row_begin;  
        }          
        // System.out.println(answer);
        for(int i = row_begin + 1; i <= row_end; i++){
            int S_i = 0;
            for(int c = 0; c < data[i - 1].length; c++){
                S_i += data[i - 1][c] % i;
            }
            // System.out.println(S_i);
            answer ^= S_i;            
        }
        return answer;
    }
}