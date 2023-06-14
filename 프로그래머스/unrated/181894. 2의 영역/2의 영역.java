class Solution {
    public int[] solution(int[] arr) {
        int start = -1;
        int end = -1;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                start = i;
                break;
            }
        }
        
        if(start == -1){
            int[] answer = {-1};
            return answer;
        }
        
        for(int i = arr.length - 1; i > -1; i--){
            if(arr[i] == 2){
                end = i;
                break;
            }
        }
        
        int[] answer = new int[end - start + 1];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr[start + i];
        }
        
        return answer;
    }
}