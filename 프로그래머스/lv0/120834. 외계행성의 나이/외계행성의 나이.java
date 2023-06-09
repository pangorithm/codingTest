class Solution {
    public String solution(int age) {
        String answer = "";
        answer = ageIntToString(age, answer);
        return answer;
    }
    
    String ageIntToString(int age, String answer){
        char chAge = (char)('a' + (age % 10));
        int tempAge = age / 10;
        if(tempAge > 0){
            answer = ageIntToString(tempAge, answer);
        }
        answer = answer.concat(Character.toString(chAge));
        return answer;
    }
}