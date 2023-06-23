class Solution {
    public String solution(String[] survey, int[] choices) {
        int r = 0;
        int t = 0;
        
        int c = 0;
        int f = 0;
        
        int j = 0;
        int m = 0;
        
        int a = 0;
        int n = 0;
        
        for(int i = 0; i < survey.length; i++){
            if(choices[i] < 4){ // 비동의
                switch(survey[i].charAt(0)){
                    case 'R':
                        r += 4 - (choices[i]);
                        break;
                    case 'T':
                        t += 4 - (choices[i]);
                        break;
                    case 'C':
                        c += 4 - (choices[i]);
                        break;
                    case 'F':
                        f += 4 - (choices[i]);
                        break;
                    case 'J':
                        j += 4 - (choices[i]);
                        break;
                    case 'M':
                        m += 4 - (choices[i]);
                        break;
                    case 'A':
                        a += 4 - (choices[i]);
                        break;
                    case 'N':
                        n += 4 - (choices[i]);
                        break;
                }
            } else if(choices[i] > 4){ // 동의
                switch(survey[i].charAt(1)){
                    case 'R':
                        r += (choices[i] % 4);
                        break;
                    case 'T':
                        t += (choices[i] % 4);
                        break;
                    case 'C':
                        c += (choices[i] % 4);
                        break;
                    case 'F':
                        f += (choices[i] % 4);
                        break;
                    case 'J':
                        j += (choices[i] % 4);
                        break;
                    case 'M':
                        m += (choices[i] % 4);
                        break;
                    case 'A':
                        a += (choices[i] % 4);
                        break;
                    case 'N':
                        n += (choices[i] % 4);
                        break;         
                }
            }
        }        
        String answer = "";
        if(r >= t){
            answer += "R";
        } else {
            answer += "T";
        }
        if(c >= f){
            answer += "C";            
        } else {
            answer += "F";            
        }
        if(j >= m){
            answer += "J";            
        } else {
            answer += "M";            
        }
        if(a >= n){
            answer += "A";            
        } else {
            answer += "N";            
        }
        return answer;
    }
}