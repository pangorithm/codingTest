class Solution {
    public String solution(String[] arr) {
        String answer = "";
        for(String str : arr){
            answer = answer.concat(str);
        }
        return answer;
    }
}