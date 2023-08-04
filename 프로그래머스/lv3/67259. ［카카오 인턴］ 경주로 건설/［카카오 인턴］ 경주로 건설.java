import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int[][][] costBoard = new int[board.length][board.length][4];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                Arrays.fill(costBoard[i][j], Integer.MAX_VALUE);
            }            
        }
        
        Queue<State> bfs = new ArrayDeque<>();
        bfs.offer(new State(0, 0, 0, 0));
        bfs.offer(new State(0, 0, 1, 0));
        
        while(bfs.size() > 0){
            State state = bfs.poll();
            
            for(int i = 0; i < 4; i++){
                int nextY = state.y;
                int nextX = state.x;
                int nextCost = state.cost;
                
                switch (i){
                    case 0 : nextX = state.x + 1; break;
                    case 1 : nextY = state.y + 1; break;
                    case 2 : nextX = state.x - 1; break;
                    case 3 : nextY = state.y - 1; break;
                }
                
                if(nextY >= 0 && nextY < board.length && nextX >= 0 && nextX < board.length){
                    if(board[nextY][nextX] != 1){
                        if(state.dir == i){
                            nextCost += 100;
                        } else {
                            nextCost += 600;                            
                        }
                        
                        if(costBoard[nextY][nextX][i] > nextCost){
                            costBoard[nextY][nextX][i] = nextCost;
                            bfs.offer(new State(nextY, nextX, i, nextCost));
                        }
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int cost : costBoard[board.length - 1][board.length - 1]){
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
    
    class State {
        int y;
        int x;
        int dir; // 0 : 동, 1 : 남, 2 : 서, 3 : 북
        int cost;
        
        State(int y, int x, int dir, int cost){
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }
    }
}