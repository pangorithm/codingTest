class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i < right + 1; i++){
            if(FactorsEven(i)){
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
    
    boolean FactorsEven(int n){
        int i = 1;
        for(; i * i < n; i++){
        }
        return (i * i == n) ? false : true;
    } 
}