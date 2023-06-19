import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        char[] carr = s.toCharArray();
        Character[] temp = new Character[carr.length];
        for(int i = 0; i < carr.length; i++){
            temp[i] = carr[i];
        }
        Arrays.sort(temp, Collections.reverseOrder());        
        for(int i = 0; i < carr.length; i++){
            carr[i] = temp[i];
        }
        return String.valueOf(carr);
    }
}