import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> cleared = new PriorityQueue<>((v1, v2) -> v2 - v1);
        int stage = 0;
        for(;stage < enemy.length; stage++){
            if(enemy[stage] > n){
                if(k > 0){
                    k--;
                    n -= enemy[stage];
                    cleared.offer(enemy[stage]);
                    n += cleared.poll();
                } else {
                    return stage;
                }
            } else {
                n -= enemy[stage];
                cleared.offer(enemy[stage]);
            }
        }
        return stage;
    }
}