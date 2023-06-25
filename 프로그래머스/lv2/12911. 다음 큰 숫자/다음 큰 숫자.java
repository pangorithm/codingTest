class Solution {
    public int solution(int n) {
        int baseCount = getOneCount(n);
        int answer = n + 1;
        while(getOneCount(answer) != baseCount){
            answer++;
        }
        return answer;
    }
    
    int getOneCount(int n){
        char[] carr = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for(char ch : carr){
            if(ch == '1'){
                count++;
            }
        }
        return count;
    }
}
