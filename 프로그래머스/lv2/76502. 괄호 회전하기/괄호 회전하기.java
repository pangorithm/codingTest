

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        for(int i = 0; i < length; i++){
            StringBuilder str = new StringBuilder();
            str.append(s.substring(i)).append(s.substring(0, i));
            if(check(str.toString())){
                answer++;
            }
        }
        return answer;
    }
    
    boolean check(String s){    
        char[] arr = s.toCharArray();
        if((arr.length & 1) == 1){
            return false;
        }
        
        char[] temp = new char[arr.length];
        int count = 0;
        int cursor = -1;
        for(int i = 0; i < arr.length; i++){
            if(cursor > -1){
                switch (arr[i]){
                    case ')' :
                        if(temp[cursor] == '('){
                            cursor--;
                            count++;
                        }
                        break;
                    case '}' :
                        if(temp[cursor] == '{'){
                            cursor--;
                            count++;
                        }
                        break;
                    case ']' :
                        if(temp[cursor] == '['){
                            cursor--;
                            count++;
                        }
                        break;
                    default:
                        temp[++cursor] = arr[i];
                        break;
                }
            } else {
                temp[++cursor] = arr[i];
            }
        }
        if(count == (arr.length >> 1)){
            return true;
        } else {
            return false;
        }
        
    }
}