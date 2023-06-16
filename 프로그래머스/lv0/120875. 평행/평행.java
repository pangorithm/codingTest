class Solution {
    public int solution(int[][] dots) {
        for(int a = 0; a < 4; a++){
            for(int b = a; b < 4; b++){
                for(int c = 0; c != a && c != b; c++){
                    for(int d = 0; d != a && d != b && d != c; d++){
                        // ab 선분의 기울기와 cd 선분의 기울기가 같으면 됨
                        int[] line1 = mkirr(Math.abs(dots[a][0] - dots[b][0]), Math.abs(dots[a][1] - dots[b][1]));
                        int[] line2 = mkirr(Math.abs(dots[c][0] - dots[d][0]), Math.abs(dots[c][1] - dots[d][1]));
                        if(line1[0] == line2[0] && line1[1] == line2[1]){
                            return 1;
                        }
                    }    
                }
            }
        }        
        return 0;
    }
    int[] mkirr(int numer, int denom){
        for(int i = 2; i < numer + 1; i++){
            if(((numer % i) == 0) && ((denom % i) == 0)){
                numer /= i;
                denom /= i;
            }
        }
        int[] irr = {numer, denom};
        return irr;
    }
}