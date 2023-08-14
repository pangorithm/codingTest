class Solution {
    public int solution(int[][] board, int[][] skill) {
        // skill = [type, r1, c1, r2, c2, degree]
        
        int[][] cumulativeSum = new int[board.length + 1][board[0].length + 1];
        for(int[] s : skill){
            cumulativeSum[s[1]][s[2]] += s[0] == 1 ? -s[5] : s[5];
            cumulativeSum[s[1]][s[4] + 1] += s[0] == 2 ? -s[5] : s[5];
            cumulativeSum[s[3] + 1][s[2]] += s[0] == 2 ? -s[5] : s[5];
            cumulativeSum[s[3] + 1][s[4] + 1] += s[0] == 1 ? -s[5] : s[5];
        }
        
        // 누적합 전 확인
        // for(int r = 0; r < cumulativeSum.length; r++){
        //     for(int c = 0; c < cumulativeSum[0].length; c++){
        //         System.out.print(cumulativeSum[r][c]+" ");
        //     }
        //     System.out.println(" ");
        // }
        // System.out.println(" ");
        
        for(int r = 0; r < board.length; r++){
            for(int c = 1; c < board[0].length; c++){
                cumulativeSum[r][c] += cumulativeSum[r][c - 1];
            }
        }
        for(int r = 1; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                cumulativeSum[r][c] += cumulativeSum[r - 1][c];
            }
        }
        
        // 누적합 후 확인
        // for(int r = 0; r < cumulativeSum.length; r++){
        //     for(int c = 0; c < cumulativeSum[0].length; c++){
        //         System.out.print(cumulativeSum[r][c]+" ");
        //     }
        //     System.out.println(" ");
        // }
        
        int answer = 0;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] + cumulativeSum[r][c] > 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}