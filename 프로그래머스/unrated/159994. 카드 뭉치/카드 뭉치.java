import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>();
        Queue<String> que2 = new LinkedList<>();
        for(String card : cards1){
            que1.add(card);
        }
        for(String card : cards2){
            que2.add(card);
        }
        for(String str : goal){
            if(str.equals(que1.peek())){
                que1.poll();
                continue;
            }
            if(str.equals(que2.peek())){
                que2.poll();
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}