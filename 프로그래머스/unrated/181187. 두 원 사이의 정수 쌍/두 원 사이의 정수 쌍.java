class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long rr1 = (long) r1 * r1;
        long rr2 = (long) r2 * r2;

        int xMin = r1;
        int xMax = r2;
        loopY : for(int y = 0; y < r2; y++){
            while(xMin > 0 && (long) y * y + (long) xMin * xMin >= rr1){
                xMin--;
            }
            while(xMax > 0 && (long) y * y + (long) xMax * xMax > rr2){
                xMax--;
            }
            if(xMax > xMin){
                answer += xMax - xMin;
            }
            // System.out.println(y+" "+xMin +" "+ xMax);
        }
        return answer << 2;
    }
}