class Solution {
    public int solution(int[] num_list) {
        int oddSum = 0;
        int evenSum = 0;
        for(int num : num_list){
            if((num & 1) == 1){
                oddSum = oddSum * 10 + num;
            } else {
                evenSum = evenSum * 10 + num;
            }
        }
        return oddSum + evenSum;
    }
}