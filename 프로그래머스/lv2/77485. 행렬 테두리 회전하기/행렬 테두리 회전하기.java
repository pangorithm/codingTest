import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int procession[][] = new int[rows][columns];
        int n = 1;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                procession[r][c] = n++;
            }
        }
        
        int[] min = new int[queries.length];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int i = 0; i < queries.length; i++){
            for(int j = 0; j < 4; j++){
                queries[i][j] -= 1;
                // System.out.println(queries[i][j]);
            }
            
            int x = queries[i][0];
            int y = queries[i][1];
            int temp = procession[x][y];
            while(x < queries[i][2]){
                if(procession[x][y] < min[i]){
                    min[i] = procession[x][y];
                }
                procession[x][y] = procession[++x][y];
            }
            while(y < queries[i][3]){
                if(procession[x][y] < min[i]){
                    min[i] = procession[x][y];
                }
                procession[x][y] = procession[x][++y];
            }
            while(x > queries[i][0]){
                if(procession[x][y] < min[i]){
                    min[i] = procession[x][y];
                }
                procession[x][y] = procession[--x][y];
            }
            while(y > queries[i][1] + 1){
                if(procession[x][y] < min[i]){
                    min[i] = procession[x][y];
                }
                procession[x][y] = procession[x][--y];
            }
            if(procession[x][y] < min[i]){
                min[i] = procession[x][y];
            }
            procession[x][y] = temp;
            
            // for(int r = 0; r < rows; r++){
            //     System.out.println(Arrays.toString(procession[r]));
            // }
            // System.out.println();
        }
        return min;
    }
}