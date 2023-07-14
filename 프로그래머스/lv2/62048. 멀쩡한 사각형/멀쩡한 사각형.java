class Solution {
    public long solution(int w, int h) {
        int gcd = getGCD(Math.max(w, h), Math.min(w, h));
        long answer = (long) w * h;
        w /= gcd;
        h /= gcd;
        return answer - gcd * (w + h - 1);
    }
    
    int getGCD(int a, int b){        
        if(a % b == 0) {
            return b;
        }        
        return getGCD(b, a % b);
    }
}