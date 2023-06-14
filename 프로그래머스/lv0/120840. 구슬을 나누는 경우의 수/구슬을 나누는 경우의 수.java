class Solution {
    public double solution(int balls, int share) {
        double answer = 1;
        for(int i = balls; i > Math.max(share, balls - share); i--){
            answer *= i;
        }
        return answer / fac(Math.min(share, balls - share));
    }
    
    double fac(int n){
        return n > 1 ? fac(n - 1) * n : 1;
    }
}