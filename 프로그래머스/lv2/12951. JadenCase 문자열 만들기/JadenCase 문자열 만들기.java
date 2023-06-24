class Solution {
    public String solution(String s) {
        char[] carr = s.toCharArray();
        if(carr[0] > 'Z'){
            carr[0] -= 'a' - 'A';
        }
        for(int i = 1; i < carr.length; i++){
            if(carr[i] == ' '){
                continue;
            } else if (carr[i - 1] == ' ') {
                if(carr[i] > 'Z'){
                    carr[i] -= 'a' - 'A';                    
                }
            } else if (carr[i] < 'a') {
                carr[i] += 'a' - 'A';
            }
        }
        return String.valueOf(carr);
    }
}