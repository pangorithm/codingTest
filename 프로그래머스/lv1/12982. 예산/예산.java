import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        int i = 0;
        for(int rq : d){
            sum += rq;
            if(sum > budget){
                return i;
            }
            i++;
        }
        return i;
    }
}