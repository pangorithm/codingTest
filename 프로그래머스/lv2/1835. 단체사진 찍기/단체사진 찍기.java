import java.util.*;

class Solution {
    static char[] people = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[][] conditions;
    static int answer;
    
    public int solution(int n, String[] data) {
        conditions = new char[data.length][5];
        for(int i = 0; i < data.length; i++){
            conditions[i] = data[i].toCharArray();
        }
        
        answer = 0;
        search("");
        
        return answer;
    }
    
    void search(String str){
        if(str.length() == 8){
            if(checkConditions(str)){
                answer++;
            }
        } else {
            for(char ch : people){
                if(!str.contains(String.valueOf(ch))){
                    search(str + ch);
                }
            }
        }
    }
    
    boolean checkConditions (String str){
        for(char[] condition : conditions){
            int a = str.indexOf(condition[0]);
            int b = str.indexOf(condition[2]);
            
            if(a != -1 && b != -1){
                switch (condition[3]){
                    case '>':
                        if((Math.abs(a - b) - 1) <= (condition[4] - '0')){
                            return false;
                        }
                        break;
                    case '=':
                        if((Math.abs(a - b) - 1) != (condition[4] - '0')){
                            return false;
                        }
                        break;
                    case '<':
                        if((Math.abs(a - b) - 1) >= (condition[4] - '0')){
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }
}