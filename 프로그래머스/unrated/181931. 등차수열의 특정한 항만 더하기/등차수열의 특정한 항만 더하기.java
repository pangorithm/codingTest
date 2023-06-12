class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i = 0; i < included.length; i++){
            answer += included[i] ? a : 0;
            a += d;
        }
        return answer;
    }
}