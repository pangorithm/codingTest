import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] sol1 = {1, 2, 3, 4, 5};
        int[] sol2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] sol3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == sol1[i % sol1.length]){
                score1++;
            }
            if(answers[i] == sol2[i % sol2.length]){
                score2++;
            }
            if(answers[i] == sol3[i % sol3.length]){
                score3++;
            }
        }
        
        int max = score1 > score2 ? (score1 > score3 ? score1 : score3) : (score2 > score3 ? score2 : score3);
        
        ArrayList<Integer> list = new ArrayList();
        if(max == score1){
            list.add(1);
        }
        if(max == score2){
            list.add(2);
        }
        if(max == score3){
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}