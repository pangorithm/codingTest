class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        for(String move : keyinput){
            switch (move){
                case "up":
                    answer[1] = answer[1] == (board[1] >> 1) ? answer[1] : answer[1] + 1;
                    break;
                case "down":
                    answer[1] = answer[1] == -(board[1] >> 1) ? answer[1] : answer[1] - 1;
                    break;
                case "right":
                    answer[0] = answer[0] == (board[0] >> 1) ? answer[0] : answer[0] + 1;
                    break;
                case "left":
                    answer[0] = answer[0] == -(board[0] >> 1) ? answer[0] : answer[0] - 1;
                    break;
            }
        }
        return answer;
    }
}