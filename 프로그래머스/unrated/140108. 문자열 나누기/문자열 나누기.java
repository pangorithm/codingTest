class Solution {
    public int solution(String s) {
        char[] carr = s.toCharArray();
        int x = 0;
        int y = 0;
        int answer = 0;
        int index = 0;
        for(int i = 0; i < carr.length; i++){
            
            if(x == y){
                answer++;
                index = i + 1;
                x = 0;
                y = 0;
            }
            
            if(index < carr.length && carr[i] == carr[index]){
                x++;
            } else {
                y++;
            }
        }
        
        return answer;
    }
}