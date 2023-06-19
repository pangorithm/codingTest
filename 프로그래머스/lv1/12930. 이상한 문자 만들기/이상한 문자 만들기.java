class Solution {
    public String solution(String s) {
        char[] carr = s.toCharArray();
        StringBuilder str = new StringBuilder();
        boolean isEven = true;
        for(char ch : carr){
            if(ch == ' '){
                isEven = true;
                str.append(' ');
                continue;
            } else if(isEven){
                str.append(Character.toUpperCase(ch));
                isEven = false;
            } else {                
                str.append(Character.toLowerCase(ch));
                isEven = true;
            }
        }
        return str.toString();
    }
}