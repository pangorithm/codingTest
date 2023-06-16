class Solution {
    public int solution(int[] common) {
        boolean isAmetic = false;
        if((common[2] - common[1] == common[1] - common[0])){
            isAmetic = true;
        }
        if(isAmetic){
            return common[common.length - 1] + common[1] - common[0];
        } else {
            
            return common[common.length - 1] * common[1] / common[0];
        }
    }
}