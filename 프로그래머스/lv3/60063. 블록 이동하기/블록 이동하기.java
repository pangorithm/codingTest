import java.util.*;

class Solution {
    HashMap<State, Integer> visitMap;
    boolean[][] boolBoard;
    Queue<State> bfs;
    
    public int solution(int[][] board) {
        visitMap = new HashMap<>();
        boolBoard = new boolean[board.length + 2][board[0].length + 2];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0){
                    boolBoard[i + 1][j + 1] = true;
                }
            }
        }
        
        bfs = new ArrayDeque<>();
        State initState = new State(1, 1, false);
        bfs.offer(initState);
        visitMap.put(initState, 0);
        
        while(bfs.size() > 0){
            State state = bfs.poll();
            int nsTime = visitMap.get(state) + 1;
            
            if(state.isVertical){ // 로봇이 세로일 경우
                // 이동
                State ns = new State(state.y + 1, state.x, state.isVertical); // 아래로 이동
                if(boolBoard[ns.y + 1][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y - 1, state.x, state.isVertical); // 위로 이동
                if(boolBoard[ns.y][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y, state.x + 1, state.isVertical); // 우로 이동
                if(boolBoard[ns.y][ns.x] && boolBoard[ns.y + 1][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y, state.x - 1, state.isVertical); // 좌로 이동
                if(boolBoard[ns.y][ns.x] && boolBoard[ns.y + 1][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                // 회전
                ns = new State(state.y, state.x - 1, !state.isVertical); // 좌상단 회전
                if(boolBoard[ns.y][ns.x] && boolBoard[ns.y + 1][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y, state.x, !state.isVertical); // 우상단 회전
                if(boolBoard[ns.y][ns.x + 1] && boolBoard[ns.y + 1][ns.x + 1] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y + 1, state.x - 1, !state.isVertical); // 좌하단 회전
                if(boolBoard[ns.y][ns.x] && boolBoard[ns.y - 1][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y + 1, state.x, !state.isVertical); // 우하단 회전
                if(boolBoard[ns.y][ns.x + 1] && boolBoard[ns.y - 1][ns.x + 1] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
            } else { // 로봇이 가로일 경우
                // 이동
                State ns = new State(state.y, state.x + 1, state.isVertical); // 우로 이동
                if(boolBoard[ns.y][ns.x + 1] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y, state.x - 1, state.isVertical); // 좌로 이동
                if(boolBoard[ns.y][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y + 1, state.x, state.isVertical); // 아래로 이동
                if(boolBoard[ns.y][ns.x] && boolBoard[ns.y][ns.x + 1] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y - 1, state.x, state.isVertical); // 위로 이동
                if(boolBoard[ns.y][ns.x] && boolBoard[ns.y][ns.x + 1] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                // 회전
                ns = new State(state.y - 1, state.x, !state.isVertical); // 좌상단 회전
                if(boolBoard[ns.y][ns.x] && boolBoard[ns.y][ns.x + 1] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y - 1, state.x + 1, !state.isVertical); // 우상단 회전
                if(boolBoard[ns.y][ns.x] && boolBoard[ns.y][ns.x - 1] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y, state.x, !state.isVertical); // 좌하단 회전
                if(boolBoard[ns.y + 1][ns.x + 1] && boolBoard[ns.y + 1][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
                ns = new State(state.y, state.x + 1, !state.isVertical); // 우하단 회전
                if(boolBoard[ns.y + 1][ns.x - 1] && boolBoard[ns.y + 1][ns.x] && nsTime < visitMap.getOrDefault(ns, 100000)){
                    visitMap.put(ns, nsTime);
                    bfs.offer(ns);
                }
                
            }
        }
        
        return Math.min(visitMap.getOrDefault(new State(board.length, board[0].length - 1, false), 100000),
                       visitMap.getOrDefault(new State(board.length - 1, board[0].length, true), 100000));
    }
    
    class State{
        int y;
        int x;
        boolean isVertical;
        
        State(int y, int x, boolean isVertical){
            this.y = y;
            this.x = x;
            this.isVertical = isVertical;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(this.y) + this.x;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()){ 
                return false;
            }
            if (this == obj){ 
                return true;
            }
            State s = (State) obj;
            if (this.y == s.y && this.x == s.x && this.isVertical == s.isVertical){
                return true;
            } else {
                return false;
            }
        }
    }
}