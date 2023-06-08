class Solution {
    public int solution(int n) {
        int answer = 0;
        if((n & 1) == 1){
            answer = n;
            for(int i = 1; i < n; i += 2){
                answer += i;
            }
        } else {
            answer = n * n;
            for(int i = 2; i < n; i += 2){
                answer += i * i;
            }
        }
        return answer;
    }
}