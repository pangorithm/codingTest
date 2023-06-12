class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int start = i; start < j + 1; start++){
            int x = start;
            while(x > 0){
                if(x % 10 == k){
                    answer++;
                }
                x /= 10;
            }
        }
        return answer;
    }
}