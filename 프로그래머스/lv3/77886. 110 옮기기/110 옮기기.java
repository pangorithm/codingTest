import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        for(int i = 0; i < s.length; i++){
            s[i] = changeSeq(s[i]);
        }
        return s;
    }
    
    String changeSeq(String s){
        char[] chars = s.toCharArray();
        
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '0'){
                if(stack.size() > 0 && stack.peek() == '1'){
                    stack.pop();
                    if(stack.size() > 0 && stack.peek() == '1'){
                        stack.pop();
                        count++;
                    } else {
                        stack.push('1');
                        stack.push('0');
                    }
                } else {                    
                    stack.push('0');
                }
            } else {
                stack.push('1');
            }
        }
                
        StringBuilder str = new StringBuilder();
        while(stack.size() > 0){
            str.append(stack.pop());
        }
        str.reverse().insert(str.lastIndexOf("0") + 1, "110".repeat(count));
        
        return str.toString();
    }
}

/*
000
001
010
011
100
101
110
111
*/  