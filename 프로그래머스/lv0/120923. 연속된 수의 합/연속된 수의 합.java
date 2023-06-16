class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if((num & 1) == 1){
            int center = total / num;
            int centerIndex = num >> 1;
            for(int i = 0; i < (num >> 1) + 1; i++){
                answer[centerIndex - i] = center - i;
                answer[centerIndex + i] = center + i;
            }
        } else {
            int cr = (total / (num >> 1)) >> 1;
            int cri = (num >> 1);
            for(int i = 0; i < (num >> 1); i++){
                answer[cri - 1 - i] = cr - i;
                answer[cri + i] = cr + 1 + i;
            }
        }
        return answer;
    }
}