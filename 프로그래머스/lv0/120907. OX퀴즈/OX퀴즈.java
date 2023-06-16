class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] temp = quiz[i].split(" ");
            answer[i] = calculate(temp[0],temp[1],temp[2]) == Integer.parseInt(temp[4]) ? "O" : "X";
        }
        return answer;
    }
    int calculate (String a, String b, String c){
        switch (b) {
            case "+":
                return Integer.parseInt(a) + Integer.parseInt(c);
            default:
                return Integer.parseInt(a) - Integer.parseInt(c);
        }
    }
}