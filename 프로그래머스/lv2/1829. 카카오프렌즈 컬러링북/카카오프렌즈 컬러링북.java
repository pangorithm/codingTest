import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] moves = {-1, 1};
        boolean[][] visited = new boolean[m][n];
        Queue<Loc> bfs = new ArrayDeque<>();
        
        for(int y = 0; y < m; y++){
            for(int x = 0; x < n; x++){
                if(picture[y][x] > 0 && visited[y][x] == false){
                    numberOfArea++;
                    int sizeOfThisArea = 0;
                    // int areaColor = picture[y][x];
                    
                    bfs.offer(new Loc(y, x));
                    visited[y][x] = true;
                    while(bfs.size() > 0){
                        Loc loc = bfs.poll();
                        sizeOfThisArea++;
                        // System.out.println(loc.y+" "+loc.x+" "+sizeOfThisArea);
                        
                        for(int move : moves){
                            int nextY = loc.y + move;
                            int nextX = loc.x + move;
                            if(nextY > -1 && nextY < m 
                              && picture[nextY][loc.x] == picture[y][x]
                              && visited[nextY][loc.x] == false){
                                bfs.offer(new Loc(nextY, loc.x));
                                visited[nextY][loc.x] = true;
                            }
                            if(nextX > -1 && nextX < n 
                              && picture[loc.y][nextX] == picture[y][x]
                              && visited[loc.y][nextX] == false){
                                bfs.offer(new Loc(loc.y, nextX));
                                visited[loc.y][nextX] = true;
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfThisArea);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    class Loc {
        int y;
        int x;
        
        Loc(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}

//[[1, 1, 1, 0], 
// [1, 1, 1, 0], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1]]