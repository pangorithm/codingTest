class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i = 0; i < n;){
            answer[i] = (long)x * (++i);
        }
        return answer;
    }
}