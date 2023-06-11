class Solution {
    public int[] solution(int n) {
        int count = 1;
        int x = n;
        while(x != 1){
            x = (x & 1) == 0 ? x >> 1 : 3 * x + 1;
           count++;
        }
        int[] answer = new int[count];
        x = n;
        for(int i = 0; i < count; i++){
            answer[i] = x;
            x = (x & 1) == 0 ? x >> 1 : 3 * x + 1;
        }
        return answer;
    }
}