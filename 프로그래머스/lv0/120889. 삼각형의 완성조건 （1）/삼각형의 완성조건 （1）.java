class Solution {
    public int solution(int[] sides) {
        int sum = 0;
        int max = 0;
        for(int side : sides){
            sum += side;
            if(side > max){
                max = side;
            }
        }
        int answer = ((sum - max) > max) ? 1 : 2;
        return answer;
    }
}