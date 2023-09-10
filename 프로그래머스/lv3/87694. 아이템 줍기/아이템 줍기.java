import java.util.*;

class Solution {
    static boolean[][] board;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX <<= 1;
        characterY <<= 1;
        itemX <<= 1;
        itemY <<= 1;
        board = new boolean[102][102];
        for(int[] r : rectangle){
            for(int i = 0; i < 4; i++){
                r[i] <<= 1;
            }
            for(int y = r[1]; y <= r[3]; y++){
                for(int x = r[0]; x <= r[2]; x++){
                    board[y][x] = true;
                }
            }
        }
        // StringBuilder sb = new StringBuilder();
        // for(int i = 100; i >= 0; i--){
        //     for(int j = 0; j < 101; j++){
        //         sb.append(board[i][j] ? 1 : 0);
        //     }
        //     sb.append("\n");
        // }
        // System.out.println(sb);
        int[] rMove;
        int[] lMove;
        if(!board[characterY + 1][characterX + 1]){
            rMove = new int[]{-1, 0};
            lMove = new int[]{0, -1};
        } else if(!board[characterY + 1][characterX - 1]){
            rMove = new int[]{0, 1};
            lMove = new int[]{-1, 0};
        } else if(!board[characterY - 1][characterX - 1]){
            rMove = new int[]{1, 0};
            lMove = new int[]{0, 1};
        } else {
            rMove = new int[]{0, -1};
            lMove = new int[]{1, 0};
        }
        Queue<State> bfs = new ArrayDeque<>();
        while(!board[characterY + rMove[0]][characterX + rMove[1]]){
            rMove = new int[] {-rMove[1], rMove[0]};
        }
        bfs.offer(new State(characterY, characterX, rMove, 'r', 0));
        while(!board[characterY + lMove[0]][characterX + lMove[1]]){
            lMove = new int[] {lMove[1], -lMove[0]};
        }
        bfs.offer(new State(characterY, characterX, lMove, 'l', 0));
        
        while(bfs.size() > 0){
            State state = bfs.poll();
            state.c++;
            
            if(state.t == 'r'){ // 시계방향 탐색 1 0   0 1   -1 0   0 -1
                state.m = new int[] {state.m[1], -state.m[0]};
                while(!board[state.y + state.m[0]][state.x + state.m[1]]){
                    state.m = new int[] {-state.m[1], state.m[0]};
                }
            } else { // 반시계방향 탐색 1 0   0 -1   -1 0   0 1
                state.m = new int[] {-state.m[1], state.m[0]};
                while(!board[state.y + state.m[0]][state.x + state.m[1]]){
                    state.m = new int[] {state.m[1], -state.m[0]};
                }
            }
            state.y += state.m[0] << 1;
            state.x += state.m[1] << 1;
            if(state.y == itemY && state.x == itemX){
                return state.c;
            } else {
                bfs.offer(state);
            }
        }
        
        return 0;
    }
    
    class State {
        int y;
        int x;
        int[] m;
        char t;
        int c;
        
        State(int y, int x, int[] move, char turn, int count){
            this.x = x;
            this.y = y;
            this.m = move;
            this.t = turn;
            this.c = count;
        }
    }
}