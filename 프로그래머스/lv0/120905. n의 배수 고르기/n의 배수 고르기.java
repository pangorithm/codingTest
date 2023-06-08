class Solution {
    public int[] solution(int n, int[] numlist) {
        int count = 0;
        for(int num : numlist){
            if(num % n == 0){
                count++;
            }
        }
        int[] answer = new int[count];
        count = 0;
        for(int num : numlist) {
            if(num % n == 0){
                for(int i = count; i < answer.length; i++){
                    answer[i] = num;
                }                
                count++;
            }
        }
        return answer;
    }
}