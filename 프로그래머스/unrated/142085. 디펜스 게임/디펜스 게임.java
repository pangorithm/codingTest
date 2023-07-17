import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> cleared = new PriorityQueue<>((v1, v2) -> v2 - v1);
        int stage = 0;
        for(;stage < enemy.length; stage++){
            n -= enemy[stage];
            cleared.offer(enemy[stage]);
            if(n < 0){
                if(k > 0){
                    k--;
                    n += cleared.poll();
                } else {
                    return stage;
                }
            }
        }
        return stage;
    }
}