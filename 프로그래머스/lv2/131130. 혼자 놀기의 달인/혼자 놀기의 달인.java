import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        Integer[] counts = new Integer[cards.length];
        for(int i = 0; i < cards.length; i++){
            int boxNo = i;
            int count = 0;
            while(visited[boxNo] == false){
                count++;
                visited[boxNo] = true;
                boxNo = cards[boxNo] - 1;
            }
            counts[i] = count;
        }
        Arrays.sort(counts, (v1, v2) -> v2 - v1);
        return counts[0] * counts[1];
    }
}