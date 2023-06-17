class Solution {
    public int[][] solution(int n) {
        int dir = 1;
        int[][] answer = new int[n][n];
        int x = 0;
        int y = 0;
        for(int i = 1; i < n * n + 1; i++){
            answer[y][x] = i;
            switch (dir){
                case 1:
                    if(answer[x + 1][y] != 0 || x == n - 1){
                        dir = 2;
                    } else {
                        x++;                        
                    }
                    break;
                case 2:
                    if(answer[x][y + 1] != 0 || y == n - 1){
                        dir = 3;
                    } else {
                        y++;                        
                    }
                    break;
                case 3:
                    if(answer[x - 1][y] != 0 || x == 0){
                        dir = 4;
                    } else {
                        x--;                        
                    }
                    break;
                case 4:
                    if(answer[x][y - 1] != 0){
                        dir = 1;
                    } else {
                        y--;                        
                    }
                    break;
            }
        }
        return answer;
    }
}