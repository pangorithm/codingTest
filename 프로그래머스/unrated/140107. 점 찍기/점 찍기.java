class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int a = d / k; a >= 0 ; a--){
            int bk = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(a * k, 2));
            
            answer += bk / k + 1;
            // System.out.println(a*k+","+ b*k);            
        }
        return answer;
    }
}