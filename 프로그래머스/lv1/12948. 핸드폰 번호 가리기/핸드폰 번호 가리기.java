class Solution {
    public String solution(String phone_number) {
        char[] carr = phone_number.toCharArray();
        for(int i = 0; i < carr.length - 4; i++){
            carr[i] = '*';
        }
        return String.valueOf(carr);
    }
}