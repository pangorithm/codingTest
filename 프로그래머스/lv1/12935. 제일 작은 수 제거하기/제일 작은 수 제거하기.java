class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            if(num < min){
                min = num;
            }
        }
        int[] answer = new int[arr.length - 1];
        if(answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        int i = 0;
        for(int num : arr){
            if(num != min){
                answer[i++] = num;
            }
        }
        return answer;
    }
}