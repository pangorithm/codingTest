import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int count = 0;
        loop : for(int a : arr){
            for(int del : delete_list){
                if(a == del){
                    continue loop;
                }
            }
            count++;
        }
        int[] answer = new int[count];
        count = 0;
        loop : for(int a : arr){
            for(int del : delete_list){
                if(a == del){
                    continue loop;
                }
            }
            answer[count] = a;
            count++;
        }
        return answer;
    }
}