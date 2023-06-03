class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = n; i > 0; i--){
            if((i & 1) == 0){
                answer += i;
            }
        }
        return answer;
    }
}