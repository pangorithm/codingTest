class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; fac(i) < n + 1; i++){
            answer = i;
        }
        return answer;
    }
    
    int fac(int x){
        return x > 1 ? fac(x - 1) * x : 1;
    }
}