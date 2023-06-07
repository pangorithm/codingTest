class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int no : numbers){
            answer += no;
            if(answer > n){
                break;
            }
        }
        return answer;
    }
}