import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        for(int i = 0; i < strs.length; i++){
            strs[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strs, (s1, s2) -> {
            char[] chs1 = s1.toCharArray();
            char[] chs2 = s2.toCharArray();
            for(int i = 0; i < ((Math.min(chs1.length, chs2.length) << 1) + 1); i++){
                if(chs1[i % chs1.length] != chs2[i % chs2.length]){
                    return chs1[i % chs1.length] - chs2[i % chs2.length];
                }
            }
            return chs2.length - chs1.length;                                                                 
        });
        
        StringBuilder answer = new StringBuilder();
        for(int i = strs.length - 1; i > -1; i--){
            answer.append(strs[i]);  
            // System.out.println(strs[i]);
        }        
        
        String answerStr = answer.toString();
        
        if(answerStr.charAt(0) != '0'){
            return answerStr;
        }
        
        return "0";
    }
}