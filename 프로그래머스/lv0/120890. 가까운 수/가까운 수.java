class Solution {
    public int solution(int[] array, int n) {
        int dif = Integer.MAX_VALUE;
        int answer = 0;
        for(int x : array){
            if(Math.abs(n - x) < dif){
                answer = x;
                dif = Math.abs(n - x);
            } else if(Math.abs(n - x) == dif){
                answer = Math.min(answer, x);
            }
        }
        return answer;
    }
}