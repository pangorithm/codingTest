class Solution {
    public int[] solution(int n, int k) {
        int length = n / k;
        int[] answer = new int[length];
        for(int i = 0; i < length;){
            answer[i] = k * (++i);
        }
        return answer;
    }
}