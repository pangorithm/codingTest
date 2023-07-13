import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Integer[][] int_time = new Integer[book_time.length][2];
        for(int i = 0; i < int_time.length; i++){
            String[] splited = book_time[i][0].split(":");
            int_time[i][0] = Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
            splited = book_time[i][1].split(":");
            int_time[i][1] = Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
        }
        Arrays.sort(int_time, (v1, v2) -> v1[0] - v2[0]);
        
        PriorityQueue<Integer> pque = new PriorityQueue<>((s1, s2) -> s1.compareTo(s2));
        for(int i = 0; i < int_time.length; i++){
            if(pque.size() == 0){
                pque.offer(int_time[i][1]);
            } else {
                while(pque.size() > 0 && (pque.peek() + 10 - int_time[i][0]) <= 0){
                    pque.poll();
                }
                pque.offer(int_time[i][1]);
            }
            if(answer < pque.size()){
                answer = pque.size();
            }
            // System.out.println(Arrays.toString(pque.toArray()));
        }
        return answer;
    }
}