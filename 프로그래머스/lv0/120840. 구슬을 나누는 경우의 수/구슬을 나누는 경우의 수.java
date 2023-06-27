class Solution {
    public int solution(int balls, int share) {
        double answer = 1;
        int temp = Math.min(share, balls - share);
        for(int i = 0; i < temp ; i++){
            answer *= balls - i;
            answer /= i + 1;
        }
        return (int) answer;
    }
}