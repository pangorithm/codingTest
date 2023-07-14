import java.util.*;

class Solution {
    static char[][][] seats = new char [5][5][5];
    
    public int[] solution(String[][] places) {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                seats[i][j] = places[i][j].toCharArray();
            }
        }
        int[] answer = {1,1,1,1,1};
        
        loop : for(int i = 0; i < 5; i++){
            for(int y = 0; y < 5; y++){
                for(int x = 0; x < 5; x++){
                    if(seats[i][y][x] == 'P'){
                        if(!checkRule(i, y, x)){
                            // System.out.println(i+"의"+y+","+x+"안지킴");
                            answer[i] = 0;
                            continue loop;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    boolean checkRule(int i, int y, int x){
        for(int moveY = -1; moveY < 2; moveY++){
            for(int moveX = -1; moveX < 2; moveX++){
                if(moveY != 0 || moveX != 0){ 
                    int nextY = y + moveY;
                    int nextX = x + moveX;
                    if(nextY >= 0 && nextY < 5 && nextX >= 0 && nextX < 5){
                        if(seats[i][nextY][nextX] == 'P'){
                            if(Math.abs(moveY) == 1 && Math.abs(moveX) == 1){ // 대각선에 위치하는 경우
                                if(seats[i][y][nextX] != 'X' || seats[i][nextY][x] != 'X'){
                                    return false;
                                }
                            } else { // 거리가 1인 경우
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        int[] move = {-2, 2};
        for(int m : move){
            int nextY = y + m;
            int nextX = x + m;
            if(nextY >= 0 && nextY < 5 && seats[i][nextY][x] == 'P'){
                if(seats[i][y + (m >> 1)][x] != 'X'){
                    return false;
                }
            }
            if(nextX >= 0 && nextX < 5 && seats[i][y][nextX] == 'P'){
                if(seats[i][y][x + (m >> 1)] != 'X'){
                    return false;
                }
            }
        }
        return true;
    }
}