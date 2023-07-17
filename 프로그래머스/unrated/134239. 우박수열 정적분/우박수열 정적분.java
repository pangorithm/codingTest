import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> collatz = new ArrayList<>();
        while(k != 1){
            collatz.add(k);
            if((k & 1) == 0){
                k >>= 1;
            } else {
                k *= 3;
                k++;
            }
        }
        collatz.add(k);
        
        double[] answer = new double[ranges.length];
        for(int i = 0; i < ranges.length; i++){
            int end = collatz.size() + ranges[i][1];
            if(ranges[i][0] < end){
                for(int xi = ranges[i][0] + 1; xi < end; xi++){
                    answer[i] += ((double)(collatz.get(xi - 1) + collatz.get(xi))) / 2;
                }
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}