class Solution {
    public int solution(int a, int b) {
        for(int i = 2; i < a + 1; i++){
            if((a % i == 0) && (b % i == 0)) {
                a /= i;
                b /= i;
            }
        }
        while((b & 1) == 0){
            b = b >> 1;
        }
        while(b % 5 == 0){
            b /= 5;
        }
        if(b == 1){
            return 1;
        } else {
            return 2;
        }
    }
}