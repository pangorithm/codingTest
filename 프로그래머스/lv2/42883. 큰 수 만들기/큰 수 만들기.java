import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        while(k > 0){   
            char[] chars = number.toCharArray();   
            char max = '0';
            int maxIndex = 0;   
            if(maxIndex == chars.length - k){
                break;
            }
            for(int i = 0; i <= k; i++){
                if(chars[i] > max){
                    max = chars[i];
                    maxIndex = i;                    
                }
                if(max == '9'){
                    break;
                }
            }
            k -= maxIndex;
            if(k == 0){
                number = number.substring(maxIndex); 
                answer.append(number);  
            } else {                   
                answer.append(chars[maxIndex]);
                number = number.substring(maxIndex + 1); 
            }
            // System.out.println(chars[maxIndex]+" "+number);
        }
        return answer.toString();
    }
}