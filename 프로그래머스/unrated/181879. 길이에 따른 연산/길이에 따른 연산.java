class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        if(num_list.length <= 10){
            for(int num : num_list){
                if(num == 0){
                    answer = 0;
                    break;
                }else if(answer == 0){
                    answer = 1;
                    answer *= num;
                }else {
                    answer *= num;
                }
                
            }
        } else {
            for(int num : num_list){
                answer += num;
            }
        }
        return answer;
    }
}