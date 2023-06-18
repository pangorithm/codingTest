class Solution {
    public String solution(String s) {
        int length = s.length();
        if((length & 1) == 1){
            length = length >> 1;
            return s.substring(length, length + 1);
        } else {            
            length = length >> 1;
            return s.substring(length - 1, length + 1);
        }
    }
}