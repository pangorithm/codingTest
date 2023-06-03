class Solution {
    public int[] solution(int[] num_list) {
        int count0 = 0;
        int count1 = 0;
        for(int num : num_list){
            if((num & 1) == 0){
                count0++;
            }else {
                count1++;
            }            
        }
        int[] answer = {count0, count1};
        return answer;
    }
}