class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            stk[i] = -1;
            if(count == 0){
                stk[count++] = arr[i];
            } else if(stk[count - 1] == arr[i]){
                stk[count-- - 1] = -1;
            } else {
                stk[count++] = arr[i];
            }
        }
        if(count == 0){
        int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[count];
        for(int i = 0; i < count; i++){
            answer[i] = stk[i];
        }
        return answer;
    }
}