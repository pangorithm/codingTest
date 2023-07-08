class Solution {
    public int[] solution(int n) {
        if(n == 1){
            return new int[] {1};
        } else if (n == 2){            
            return new int[] {1, 2, 3};
        } else if (n == 3){
            return new int[] {1, 2, 6, 3, 4, 5};
        }
        int[][] square = new int[n][n];
        int y = 0;
        int x = 0;
        int i = 1;
        square[0][0] = i++;
        while(true){
            while((y + 1) < n && square[y + 1][x] == 0){
                square[++y][x] = i++;
            }
            while((x + 1) < n && square[y][x + 1] == 0){
                square[y][++x] = i++;
            }
            while(y > 0 && x > 0 && square[y - 1][x -1] == 0){
                square[--y][--x] = i++;
            }
            if(square[y + 1][x] != 0 && square[y][x + 1] != 0 && square[y - 1][x - 1] != 0){
                break;
            }
        }
        
        int[] answer = new int[(n * (n + 1)) >> 1];
        i = 0;
        for(y = 0; y < n; y++){
            for(x = 0; x <= y; x++){
                answer[i++] = square[y][x];
            }
        }
        return answer;
    }
}