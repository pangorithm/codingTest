import java.util.*;

class Solution {
    static boolean[][][] wall;
    
    public int[][] solution(int n, int[][] build_frame) {
        wall = new boolean[n + 1][n + 1][2]; // [x][y][기둥||보]
        
        for(int[] build : build_frame){
            if(build[3] == 1){ // 구조물 추가
                if(checkCanBuild(build[0], build[1], build[2], n)){
                    wall[build[0]][build[1]][build[2]] = true;     
                }                
            } else { // 구조물 삭제
                wall[build[0]][build[1]][build[2]] = false;
                if(build[2] == 0){ // 기둥
                    if(build[1] <= n && wall[build[0]][build[1] + 1][0]){
                        if(!checkCanBuild(build[0], build[1] + 1, 0, n)){                            
                            wall[build[0]][build[1]][build[2]] = true;
                            continue;
                        }
                    }    
                    if(build[0] > 0 && build[1] <= n && wall[build[0] - 1][build[1] + 1][1]){
                        if(!checkCanBuild(build[0] - 1, build[1] + 1, 1, n)){                            
                            wall[build[0]][build[1]][build[2]] = true;
                            continue;
                        }
                    }
                    if(build[0] <= n && build[1] <= n && wall[build[0]][build[1] + 1][1]){
                        if(!checkCanBuild(build[0], build[1] + 1, 1, n)){                            
                            wall[build[0]][build[1]][build[2]] = true;
                            continue;
                        }
                    }
                } else { // 보
                    if(wall[build[0]][build[1]][0]){
                        if(!checkCanBuild(build[0], build[1], 0, n)){
                            wall[build[0]][build[1]][build[2]] = true;
                            continue;
                        }
                    }
                    if(build[0] <= n && wall[build[0] + 1][build[1]][0]){
                        if(!checkCanBuild(build[0] + 1, build[1], 0, n)){
                            wall[build[0]][build[1]][build[2]] = true;
                            continue;
                        }
                    }
                    if(build[0] > 0 && wall[build[0] - 1][build[1]][1]){
                        if(!checkCanBuild(build[0] - 1, build[1], 1, n)){
                            wall[build[0]][build[1]][build[2]] = true;
                            continue;
                        }
                    }
                    if(build[0] <= n && wall[build[0] + 1][build[1]][1]){
                        if(!checkCanBuild(build[0] + 1, build[1], 1, n)){
                            wall[build[0]][build[1]][build[2]] = true;
                            continue;
                        }
                    }
                }
            }
        }
        
        ArrayList<Integer[]> frameList = new ArrayList<>();
        for(int x = 0; x <= n; x++){
            for(int y = 0; y <= n; y++){
                for(int i = 0; i < 2; i++){
                    if(wall[x][y][i]){
                        Integer[] frame = new Integer[3];
                        frame[0] = x;
                        frame[1] = y;
                        frame[2] = i;
                        frameList.add(frame);
                    }
                }
            }
        }
        
        int[][] answer = new int[frameList.size()][3];
        for(int i = 0; i < answer.length; i++){
            answer[i][0] = frameList.get(i)[0];
            answer[i][1] = frameList.get(i)[1];
            answer[i][2] = frameList.get(i)[2];
            // System.out.println(Arrays.toString(answer[i]));
        }
        return answer;
    }
    
    boolean checkCanBuild(int x, int y, int i, int n){
        if(i == 0){ // 기둥
            if(y == 0 
               || wall[x][y - 1][0] 
               || (x == 0 ? false : wall[x - 1][y][1])
               || wall[x][y][1] ){
                return true;
            }
        } else { // 보
            if(wall[x][y - 1][0] 
                || (wall[x + 1][y - 1][0])
                || ((x == 0 ? false : wall[x - 1][y][1]) 
                    && (wall[x + 1][y][1])) ){
                return true;
            }
        }
        return false;
    }
}