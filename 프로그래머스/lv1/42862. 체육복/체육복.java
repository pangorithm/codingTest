import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n];
        
        for(int num : reserve){
            count[num - 1]++;
        }
        for(int num : lost){            
            count[num - 1]--;            
        }
        
        Arrays.sort(lost);
        
        for(int num : lost){
            if(count[num - 1] > -1){
                
            }
            else if(num > 1 && count[num - 2] > 0){
                count[num - 2]--;
                count[num - 1]++;
            } else if(num < n && count[num] > 0){
                count[num]--;
                count[num - 1]++;
            }
        }
        
        int answer = 0;
        for(int x : count){
            if(x > -1){
                answer++;
            }
        }
        
        return answer;
    }
}