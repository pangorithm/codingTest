class Solution {
    public String solution(String my_string) {
        String answer = "";
        while(my_string.length() > 0){
            String str0 = "" + my_string.charAt(0);
            answer = answer.concat(str0);
            my_string = my_string.replaceAll(str0, "");
        }
        return answer;
    }
}