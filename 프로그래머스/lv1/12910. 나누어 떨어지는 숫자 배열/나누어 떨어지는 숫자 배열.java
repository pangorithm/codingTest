import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num : arr){
            if(num % divisor == 0){
                list.add(num);
            }
        }
        list.sort(Comparator.naturalOrder());
        if(list.size() == 0){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}