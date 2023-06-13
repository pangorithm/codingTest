class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        while(myString.length() > 0){
            if(myString.startsWith(pat)){
                answer++;
            }
            myString = myString.substring(1);
        }
        return answer;
    }
}