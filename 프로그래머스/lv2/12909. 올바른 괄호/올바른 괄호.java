class Solution {
    boolean solution(String s) {

        int count = 0;
        char[] carr = s.toCharArray();
        for(char ch : carr){
            if(ch == '('){
                count++;
            } else {
                count--;
            }
            if(count < 0){
                return false;
            }
        }

        return count == 0 ? true : false;
    }
}