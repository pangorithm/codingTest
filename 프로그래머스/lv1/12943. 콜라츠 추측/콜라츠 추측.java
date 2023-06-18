class Solution {
    public int solution(int num) {
        int i = 0;
        long x = num;
        for(; i < 501; i++){            
            if(x == 1){
                return i;
            }
            if((x & 1) == 0){
                x = x >> 1;
            } else {
                x = x * 3 + 1;
            }
        }
        return -1;
    }
}