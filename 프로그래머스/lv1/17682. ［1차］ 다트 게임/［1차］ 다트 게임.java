import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        String[] str = dartResult.split("[^0-9]+");
        char[] carr = dartResult.replaceAll("[0-9]", "").toCharArray();
        int[] num = new int[str.length];
        int i = 0;
        for(; i < str.length;i++){
            num[i] = Integer.parseInt(str[i]);            
        }
        i = -1;
        for(char ch : carr){
            switch(ch){
                case 'S':
                    i++;
                    break;
                case 'D':
                    i++;
                    num[i] = num[i] * num[i];
                    break;
                case 'T':
                    i++;
                    num[i] = num[i] * num[i] * num[i];
                    break;
                case '*':
                    if(i > 0){
                        num[i - 1] = num[i - 1] << 1;
                    }
                    num[i] = num[i] << 1;
                    break;
                case '#':
                    num[i] *= -1;
                    break;
            }
            // System.out.println(num[i]);
        }
        
        int answer = 0;
        
        for(i = 0; i < str.length;i++){
            answer += num[i];            
        }
        
        return answer;
    }
}