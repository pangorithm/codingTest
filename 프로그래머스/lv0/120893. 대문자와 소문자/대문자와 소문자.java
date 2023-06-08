class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) >= 'a' && my_string.charAt(i) <= 'z'){
                answer = answer.concat(Character.toString(my_string.charAt(i)).toUpperCase());
            } else {
                answer = answer.concat(Character.toString(my_string.charAt(i)).toLowerCase());
            }
        }
        return answer;
    }
}