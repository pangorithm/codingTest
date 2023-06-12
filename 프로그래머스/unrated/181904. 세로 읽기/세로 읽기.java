class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        char[] chars = my_string.toCharArray();
        for(int i = 0; i < chars.length ; i++){
            if(i % m + 1 == c){
                answer += String.valueOf(chars[i]);
            }
        }
        return answer;
    }
}