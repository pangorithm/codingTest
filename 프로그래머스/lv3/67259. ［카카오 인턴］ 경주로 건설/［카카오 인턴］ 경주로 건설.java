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
                switch (i){
                    case 0 :
                        nextX = state.x + 1;
                        if(nextX < board.length){
                            if(board[state.y][nextX] != 1){
                                if(state.dir == i){
                                    int nextCost = state.cost + 100;
                                    if(costBoard[state.y][nextX][i] > nextCost){
                                        costBoard[state.y][nextX][i] = nextCost;
                                        bfs.offer(new State(state.y, nextX, i, nextCost));
                                    }
                                } else {
                                    int nextCost = state.cost + 600;
                                    if(costBoard[state.y][nextX][i] > nextCost){
                                        costBoard[state.y][nextX][i] = nextCost;
                                        bfs.offer(new State(state.y, nextX, i, nextCost));
                                    }
                                }
                            }
                        }
                        break;
                    case 1 :
                        nextY = state.y + 1;
                        if(nextY < board.length){
                            if(board[nextY][state.x] != 1){
                                if(state.dir == i){
                                    int nextCost = state.cost + 100;
                                    if(costBoard[nextY][state.x][i] > nextCost){
                                        costBoard[nextY][state.x][i] = nextCost;
                                        bfs.offer(new State(nextY, state.x, i, nextCost));
                                    }
                                } else {
                                    int nextCost = state.cost + 600;
                                    if(costBoard[nextY][state.x][i] > nextCost){
                                        costBoard[nextY][state.x][i] = nextCost;
                                        bfs.offer(new State(nextY, state.x, i, nextCost));
                                    }
                                }
                            }
                        }
                        break;
                    case 2 :
                        nextX = state.x - 1;
                        if(nextX >= 0){
                            if(board[state.y][nextX] != 1){
                                if(state.dir == i){
                                    int nextCost = state.cost + 100;
                                    if(costBoard[state.y][nextX][i] > nextCost){
                                        costBoard[state.y][nextX][i] = nextCost;
                                        bfs.offer(new State(state.y, nextX, i, nextCost));
                                    }
                                } else {
                                    int nextCost = state.cost + 600;
                                    if(costBoard[state.y][nextX][i] > nextCost){
                                        costBoard[state.y][nextX][i] = nextCost;
                                        bfs.offer(new State(state.y, nextX, i, nextCost));
                                    }
                                }
                            }
                        }
                        break;
                    case 3 :
                        nextY = state.y - 1;
                        if(nextY >= 0){
                            if(board[nextY][state.x] != 1){
                                if(state.dir == i){
                                    int nextCost = state.cost + 100;
                                    if(costBoard[nextY][state.x][i] > nextCost){
                                        costBoard[nextY][state.x][i] = nextCost;
                                        bfs.offer(new State(nextY, state.x, i, nextCost));
                                    }
                                } else {
                                    int nextCost = state.cost + 600;
                                    if(costBoard[nextY][state.x][i] > nextCost){
                                        costBoard[nextY][state.x][i] = nextCost;
                                        bfs.offer(new State(nextY, state.x, i, nextCost));
                                    }
                                }
                            }
                        }
                        break;
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