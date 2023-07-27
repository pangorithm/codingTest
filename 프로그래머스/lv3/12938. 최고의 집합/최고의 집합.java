class Solution {
    public int[] solution(int n, int s) {
        if(n > s){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[n];
        int start = s / n;
        int dif = s % n;
        
        for(int i = 0; i < n; i++){
            answer[i] = start;
        }
        for(int i = 1; i <= dif; i++){
            answer[answer.length - i] += 1;
        }        
        
        return answer;
    }
}