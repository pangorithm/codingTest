class Solution {
    public int[] solution(int start, int end) {
        int count = end - start + 1;
        int[] answer = new int[count];
        for(int i = 0; i < count; i++){
            answer[i] = start + i;
        }
        return answer;
    }
}