import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        int count = 0;
        
        while(index < progresses.length){
            if(progresses[index] >= 100){
                index++;
                count++;
                continue;
            } else if(index > 0 && count > 0 && progresses[index - 1] >= 100){
                list.add(count);
                count = 0;
            }
            for(int i = 0; i < speeds.length; i++){
                progresses[i] += speeds[i];
            }
        }
        if(count > 0){
            list.add(count);
        }
        
        Integer[] arr = list.toArray(new Integer[list.size()]);
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}