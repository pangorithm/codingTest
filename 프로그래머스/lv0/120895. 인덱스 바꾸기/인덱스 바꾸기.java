class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        answer = answer.concat(my_string.substring(0, num1)).concat(my_string.substring(num2, num2 + 1)).concat(my_string.substring(num1 + 1, num2)).concat(my_string.substring(num1, num1 + 1)).concat(my_string.substring(num2 + 1));
        return answer;
    }
}