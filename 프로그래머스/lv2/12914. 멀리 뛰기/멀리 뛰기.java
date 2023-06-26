class Solution {
    static long[][] ncr;
    
    public long solution(int n) {
        ncr = new long[n][(n >> 1) + 1];
        int ans = 0;
        for(int i = 0; i <= (n >> 1); i++){
            // i = 2의 갯수
            int oneCount = n - (i << 1); 
            ans += getNCR(i + oneCount, i);
        }
        return ans % 1234567;
    }
    
    long getNCR(int n, int r){
        r = Math.min(n - r, r);
        if (ncr[n - 1][r] != 0){
            return ncr[n - 1][r];
        }
        if(r == 0){
            return 1;
        } if (r == 1){
            return n;
        }
        ncr[n - 1][r] = (getNCR(n - 1, r - 1) + getNCR(n - 1, r)) % 1234567;
        return ncr[n - 1][r];
    }
}