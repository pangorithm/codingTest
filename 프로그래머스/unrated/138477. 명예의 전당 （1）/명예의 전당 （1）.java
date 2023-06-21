import java.util.LinkedList;

class Solution {
    public int[] solution(int k, int[] score) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] answer = new int[score.length];
        loop : for(int j = 0; j < score.length; j++){
            if(j > 0){
                if(list.size() > k){
                    answer[j - 1] = list.get(k - 1);
                } else {
                    answer[j - 1] = list.peekLast();
                }
                
            }
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) < score[j]){
                    list.add(i, score[j]);
                    continue loop;
                }
            }
            list.add(score[j]);
        }
        if(list.size() > k){
            answer[score.length - 1] = list.get(k - 1);
        } else {
            answer[score.length - 1] = list.peekLast();
        }
        return answer;
    }
}