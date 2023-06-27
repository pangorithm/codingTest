class Solution {
    static int[][] ncr;
        
    public int solution(int balls, int share) {
        ncr = new int[balls][Math.min(share, balls - share) + 1];  
        return getNCR(balls, share);
    }
    
    int getNCR(int n, int r){
        r = Math.min(r, n - r);
        if(r == 0){
            return 1;
        } else if (r == 1){
            return n;
        }
        if(ncr[n - 1][r] != 0){
            return ncr[n - 1][r];
        }
        ncr[n - 1][r] = getNCR(n - 1, r) + getNCR(n - 1, r - 1);
        return ncr[n - 1][r];
    }
}