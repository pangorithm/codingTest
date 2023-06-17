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
                    if((x == (n - 1)) || (answer[y][x + 1] != 0)){
                        dir = 2;
                        y++;
                    } else {
                        x++;                        
                    }
                    break;
                case 2:
                    if((y == (n - 1)) || (answer[y + 1][x] != 0)){
                        dir = 3;
                        x--;
                    } else {
                        y++;                        
                    }
                    break;
                case 3:
                    if((x == 0) || (answer[y][x - 1] != 0)){
                        dir = 4;
                        y--;
                    } else {
                        x--;                        
                    }
                    break;
                case 4:
                    if(answer[y - 1][x] != 0){
                        dir = 1;
                        x++;
                    } else {
                        y--;                        
                    }
                    break;
                default:
                    break;
            }
        }
        return answer;
    }
}