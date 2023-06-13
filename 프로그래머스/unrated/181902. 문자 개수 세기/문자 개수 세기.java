class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(int i = 0; i < my_string.length(); i++){
            answer[my_string.charAt(i) > 'Z' ? my_string.charAt(i) - 'a' + 26 : my_string.charAt(i) - 'A']++; 
        }
        return answer;
    }
}