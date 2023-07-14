class Solution {
    public long solution(int w, int h) {
        int gcd = getGCD(Math.max(w, h), Math.min(w, h));
        return (long) w * h - gcd * (w / gcd + h / gcd - 1);
    }
    
    int getGCD(int a, int b){        
        if(a % b == 0) {
            return b;
        }        
        return getGCD(b, a % b);
    }
}