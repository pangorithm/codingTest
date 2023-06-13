class Solution {
    public int[] solution(int[] arr) {
        int n = 1;
        while(n < arr.length){
            n = n << 1;
        }
        int[] answer = new int[n];
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}