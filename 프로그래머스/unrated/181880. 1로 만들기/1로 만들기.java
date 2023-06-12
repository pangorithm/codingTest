class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int num : num_list){
            int count = 0;
            while(num != 1){
                num = num >> 1;
                count++;
            }
            answer += count;
        }
        return answer;
    }
}