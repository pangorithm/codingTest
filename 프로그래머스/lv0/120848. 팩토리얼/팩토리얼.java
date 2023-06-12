class Solution {
    public int solution(int n) {
        int fac = 1;
        int x = 1;
        while(fac < n + 1){
            x++;
            fac *= x;
        }
        return x - 1;
    }
}