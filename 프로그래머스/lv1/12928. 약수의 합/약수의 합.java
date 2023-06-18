class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        for(; i * i < n; i++){
            if(n % i == 0){
                answer += i + n / i;
            }            
        }
        if(i * i == n){
            answer += i;
        }
        return answer;
    }
}