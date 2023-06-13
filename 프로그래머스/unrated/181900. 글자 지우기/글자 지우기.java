class Solution {
    public String solution(String my_string, int[] indices) {
        char[] carr = my_string.toCharArray();
        String answer = "";
        loop : for(int i = 0; i < carr.length; i++){
            for(int j = 0; j < indices.length; j++){
                if(i == indices[j]){
                    continue loop;
                }
            }
            answer = answer.concat(Character.toString(carr[i]));
        }
        return answer;
    }
}