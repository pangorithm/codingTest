class Solution {
    public int solution(int[] num_list) {
       
        int multiple = 1;
        int sum = 0;
        for(int num : num_list){
            multiple *= num;
            sum += num;
        }
        return (multiple < (sum * sum)) ? 1 : 0;
    }
}