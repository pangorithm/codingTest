class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int rank = 7;
        int zeroCount = 0;
        for(int pick : lottos){
            if(pick == 0){
                zeroCount++;
                continue;
            }
            for(int num : win_nums){
                if(pick == num){
                    rank--;
                }
            }
        }
        int[] answer = {Math.min(rank - zeroCount, 6), Math.min(rank, 6)};
        return answer;
    }
}