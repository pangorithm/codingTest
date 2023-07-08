import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, sequence[0]);
        for(int i = 1; i < sequence.length; i++){
            map.put(i, map.get(i - 1) + sequence[i]);
        }
        
        HashMap<String, Integer> sumMap = new HashMap<>();   
        int start = 0;
        int end = 0;
        
        while(end < sequence.length){
            int sum = map.get(end) - map.get(start) + sequence[start];
            if(sum == k){
                sumMap.put(start + " " + end, end - start);
                start++;
                end++;
            } else if (sum < k){
                if(end + 1 >= sequence.length){
                    break;
                }
                if(k - sum < sequence[end + 1]){
                    start++;
                }
                end++;
            } else { // sum > k
                start++;
                if(start >= sequence.length){
                    break;
                }
            }
        }
                
        int minLength = sequence.length;
        int[] answer = new int[2];
        for(String str : sumMap.keySet()){
            int length = sumMap.get(str);
            if(minLength > length){
                minLength = length;
                String[] temp = str.split(" ");
                answer[0] = Integer.parseInt(temp[0]);
                answer[1] = Integer.parseInt(temp[1]); 
            } else if(minLength == length){                
                String[] temp = str.split(" ");
                if(answer[0] > Integer.parseInt(temp[0])){                    
                    answer[0] = Integer.parseInt(temp[0]);
                    answer[1] = Integer.parseInt(temp[1]); 
                }
            }
        }
        // System.out.println(sumMap);
        return answer;
    }
}