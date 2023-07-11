import java.util.*;

class Solution {
    public long solution(String expression) {
        
        String[] operators = {"+", "-", "*"};
        Stack<String> dfs = new Stack<>();
        long max = 0;
        
        for(String op : operators){
            dfs.push(op);
        }
        
        // System.out.println(operate("50*6-3*2", '-'));
        // System.out.println(calculate("-2*-1"));
        
        while(!dfs.empty()){
            String state = dfs.pop();
            
            if(state.length() == 3){
                String result = expression;
                for(char ch : state.toCharArray()){
                    result = operate(result, ch);
                }
                long value = Math.abs(Long.parseLong(result));
                if(value > max){
                    max = value;
                }
            } else {
                for(String op : operators){
                    if(!state.contains(op)){
                        dfs.push(state + op);
                    }
                }
                
            }
        }
        
        return max;
    }
    
    public String operate(String str, char operator){
        char[] chars;
        int startIndex = 0;
        int endIndex;
        while(checkContainsOperator(str, operator)){
            chars = str.toCharArray();
            int i = 1;
            while(i < chars.length){
                if(chars[i] == operator){
                    i++;
                    break;
                }
                else if(chars[i] != operator 
                   && (chars[i] == '+' || chars[i] == '-' || chars[i] == '*')){
                    startIndex = ++i;
                }  
                i++;
            }
            endIndex = ++i;
            while(i < chars.length){
                if(chars[i] >= '0' && chars[i] <= '9'){
                    endIndex = ++i;
                } else {
                    break;
                }
            }
            String strSub = str.substring(startIndex, endIndex);            
            // System.out.println(str+"  "+strSub);
            str = str.substring(0, startIndex) + calculate(strSub) + str.substring(endIndex);   
            // System.out.println(str);
        }
        return str;
    }
    
    public static boolean checkContainsOperator(String str, char op){
        if(op == '-'){
            return str.matches(".*[0-9][\\-].*");
        } else {
            return str.contains(String.valueOf(op));
        }
    }
    
    public static String calculate(String str){
        char[] carr = str.toCharArray();
        StringBuilder before = new StringBuilder();
        StringBuilder after = new StringBuilder();
        before.append(carr[0]);
        int i = 1;
        while(i < carr.length && carr[i] >= '0' && carr[i] <= '9'){
            before.append(carr[i++]);
        }
        char operator = carr[i++];
        while(i < carr.length){
            after.append(carr[i++]);
        }
        switch (operator) {
            case '+':
                return Long.toString(
                    Long.parseLong(before.toString()) + Long.parseLong(after.toString()));
            case '-':
                return Long.toString(
                    Long.parseLong(before.toString()) - Long.parseLong(after.toString()));
            case '*':
                return Long.toString(
                    Long.parseLong(before.toString()) * Long.parseLong(after.toString()));
            default :
                return "올바르지 않은 연산자";
        }
    }
}