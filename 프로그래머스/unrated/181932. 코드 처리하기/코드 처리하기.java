class Solution {
    public String solution(String code) {
        int length = code.length();
        boolean mode = false;
        int idx = 0;
        char[] ret = new char[length];
        for(int i = 0; i < length; i++){
            char ch = code.charAt(i);
            if(!mode){ // 모드가 0
                if(ch != '1'){
                    if((i & 1) == 0){
                        ret[idx++] = ch;
                    }
                } else {
                    mode = !mode;
                }
            } else { // 모드가 1
                if(ch != '1'){
                    if((i & 1) == 1){                        
                        ret[idx++] = ch;
                    }
                } else {
                    mode = !mode;
                }
            }
        }
        char[] answer = new char[idx];
        for(int i = 0; i < idx; i++){
            answer[i] = ret[i];
        }
        return idx > 0 ? String.valueOf(answer) : "EMPTY";
    }
}