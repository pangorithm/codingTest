import java.util.*;

class Solution {
    static char[][] gridArr;
    
    public int[] solution(String[] grid) {
        gridArr = new char[grid.length][grid[0].length()];
        boolean[][][] visited = new boolean[gridArr.length][gridArr[0].length][4]; // 동서남북
        for(int i = 0; i < grid.length; i++){
            gridArr[i] = grid[i].toCharArray();
        }
        
        List<Integer> answerList = new ArrayList<>();
        for(int y = 0; y < gridArr.length; y++){
            for(int x = 0; x < gridArr[0].length; x++){
                for(int d = 0; d < 4; d++){
                    if(!visited[y][x][d]){
                        int length = 0;
                        State state = new State(new int[2], new int[2]);
                        state.loc[0] = y;
                        state.loc[1] = x;
                        switch (d){
                            case 0: state.dir[1] = 1; break; // 동
                            case 1: state.dir[1] = -1; break; // 서
                            case 2: state.dir[0] = 1; break; // 남
                            case 3: state.dir[0] = -1; break; // 북
                        }
                        
                        int nextD = d;                        
                        do {
                            visited[state.loc[0]][state.loc[1]][nextD] = true;
                            state.loc[0] = 
                                (gridArr.length + state.loc[0] + state.dir[0]) % gridArr.length;
                            state.loc[1] = 
                                (gridArr[0].length + state.loc[1] + state.dir[1]) % gridArr[0].length;
                            state.dir = changeDir(gridArr[state.loc[0]][state.loc[1]], state.dir);
                            if(state.dir[0] == 0){
                                if(state.dir[1] == 1){
                                    nextD = 0;
                                } else if (state.dir[1] == -1){
                                    nextD = 1;
                                }
                            } else if (state.dir[0] == 1){
                                nextD = 2;
                            } else if (state.dir[0] == -1){
                                nextD = 3;
                            }
                            length++;
                        } while(!visited[state.loc[0]][state.loc[1]][nextD]);
                        
                        answerList.add(length);
                    }
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    // dir = {y, x}
    int[] changeDir (char lens, int[] dir){
        int[] result = new int[2];
        switch (lens){
            case 'L':                
                result[0] = -dir[1];
                result[1] = dir[0];
                return result;
                // {1,0} {0,1}  {-1,0} {0,-1}
                // {0,1} {-1,0} {0,-1} {1,0}
            case 'R':
                result[0] = dir[1];
                result[1] = -dir[0];
                return result;
                // {1,0}  {0,1} {-1,0} {0,-1}
                // {0,-1} {1,0} {0,1}  {-1,0}
            default : return dir;                
        }
    }
    
    class State {
        int[] loc;
        int[] dir;
        
        State(int[] loc, int[] dir) {
            this.loc = loc;
            this.dir = dir;
        }
    }
}