import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != prev){
                list.add(arr[i]);
                prev = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}