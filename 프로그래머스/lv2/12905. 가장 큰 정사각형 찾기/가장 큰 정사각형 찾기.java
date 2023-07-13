class Solution {
    public int solution(int [][]board) {
        int max = 0;
        for(int y = 1; y < board.length; y++){
            for(int x = 1; x < board[0].length; x++){
                if(board[y][x] != 0){
                    board[y][x] = 
                        Math.min(Math.min(board[y - 1][x], board[y][x - 1]), board[y - 1][x - 1]) + 1;
                }
                max = Math.max(max, board[y][x]);
            }
        }
        if(max == 0){
            for(int i = 0; i < board.length; i++){
                if(board[i][0] == 1){
                    return 1;
                }
            }
            for(int i = 0; i < board[0].length; i++){
                if(board[0][i] == 1){
                    return 1;
                }
            }
        }
        return max * max;
    }
}