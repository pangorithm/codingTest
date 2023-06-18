class Solution {
    public long solution(long n) {
        long x = 1;
        while(x * x < n){
            x++;
        }
        if(x * x++ == n){
            return x * x;
        } else {
            return -1;
        }
    }
}