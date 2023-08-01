import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        
        for(int i = 0; i < k; i++){
            while(deq.size() > 0 && stones[i] > deq.getLast()){
                deq.removeLast();
            }
            
            deq.addLast(stones[i]);
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = k; i < stones.length; i++){
            if(answer > deq.getFirst()){
                answer = deq.getFirst();
            }
            
            while(deq.size() > 0 && deq.getLast() < stones[i]){
                deq.removeLast();
            }
            
            deq.addLast(stones[i]); 
            
            if(deq.getFirst() == stones[i - k]){
                deq.removeFirst();
            }
            // System.out.println(Arrays.toString(deq.toArray(new Integer[0])));
        }
        if(answer > deq.getFirst()){
            answer = deq.getFirst();
        }
        
        return answer;
    }
}