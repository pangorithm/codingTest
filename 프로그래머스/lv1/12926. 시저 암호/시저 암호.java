class Solution {
    public String solution(String s, int n) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(Character.isUpperCase(ch[i])){
                ch[i] = (char) ((int) ch[i] + n);
                if(ch[i] > 'Z'){
                    ch[i] -= 26;
                }
            } else if(Character.isLowerCase(ch[i])){
                ch[i] = (char) ((int) ch[i] + n);
                if(ch[i] > 'z'){
                    ch[i] -= 26;
                }
            }
        }
        return String.valueOf(ch);
    }
}