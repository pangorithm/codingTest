class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    count++;
                    for(int k = Math.max(0, i - 1); k < Math.min(n, i + 2);k++){
                        for(int l = Math.max(0, j - 1); l < Math.min(n, j + 2);l++){
                            if(board[k][l] == 0){
                                board[k][l] = 2;
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return n * n - count;
    }
}