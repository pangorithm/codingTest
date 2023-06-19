class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGcd(Math.max(n, m), Math.min(n, m));
        int[] answer = {gcd, n * m / gcd};
        return answer;
    }
    
    int getGcd(int a, int b){
        if(b == 0){
            return a;
        }
        return getGcd(b, a % b);
    }
}