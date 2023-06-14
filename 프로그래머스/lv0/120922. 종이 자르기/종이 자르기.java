class Solution {
    public int solution(int M, int N) {
        if(M == 1){
            if(N == 1){
                return 0;
            } else {
                return Math.max((N - 1), 1);
            } 
        }
        return Math.max((M - 1), 1) + M * Math.max((N - 1), 1);
    }
}