class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(!(arr[i] < 50) && ((arr[i] & 1) == 0)){
                answer[i] = arr[i] >> 1;
            } else if((arr[i] < 50) && ((arr[i] & 1) == 1)){
                answer[i] = arr[i] << 1;
            } else {
                answer[i] = arr[i];
            }
        }
        return answer;
    }
}