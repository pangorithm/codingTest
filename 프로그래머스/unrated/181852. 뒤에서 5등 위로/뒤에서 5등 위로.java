class Solution {
    public int[] solution(int[] num_list) {
        boolean finish = true;
        do {
            finish = true;
            for(int i = 0; i < num_list.length - 1; i++){
                if(num_list[i] > num_list[i + 1]){
                    int temp = num_list[i];
                    num_list[i] = num_list[i + 1];
                    num_list[i + 1] = temp;
                    finish = false;
                }
            }
        } while(!finish);
        
        int[] answer = new int[num_list.length - 5];
        for(int i = 0; i < answer.length; i++){
            answer[i] = num_list[i + 5];
        }
        return answer;
    }
}