import java.util.*;

class Solution {
    public int solution(String[] board) {
        char[][] b = new char[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++){
            b[i] = board[i].toCharArray();
        }
        boolean[][] canVisit = new boolean[b.length][b[0].length];
        int[] from = new int[2];
        int[] to = new int[2];
        for(int y = 0; y < canVisit.length; y++){
            for(int x = 0; x < canVisit[0].length; x++){
                switch(b[y][x]){
                    case '.': canVisit[y][x] = true; break;
                    case 'R': 
                        from[0] = y;
                        from[1] = x;
                        break;
                    case 'G': 
                        canVisit[y][x] = true; 
                        to[0] = y;
                        to[1] = x;
                        break;
                }
            }
        }
        // System.out.println(Arrays.toString(from));
        // System.out.println(Arrays.toString(to));
        // for(boolean[] temp : canVisit){
        //     System.out.println(Arrays.toString(temp));
        // }
        
        Queue<Loc> bfs = new ArrayDeque<>();
        bfs.offer(new Loc(from[0], from[1], 0));
        int[] move = {-1, 1};
        while(bfs.size() > 0){
            Loc loc = bfs.poll();
            // System.out.println(loc.y+" "+loc.x+" "+loc.time);
            if(loc.y == to[0] && loc.x == to[1]){
                return loc.time;
            } 
            for(int m : move){
                int nextY = loc.y;
                int nextX = loc.x;
                while(nextY + m >= 0 && nextY + m < b.length && b[nextY + m][loc.x] != 'D'){
                    nextY += m;
                }
                while(nextX + m >= 0 && nextX + m < b[0].length && b[loc.y][nextX + m] != 'D'){
                    nextX += m;
                }
                if(canVisit[nextY][loc.x] == true){
                    bfs.offer(new Loc(nextY, loc.x, loc.time + 1));
                    canVisit[nextY][loc.x] = false;
                }
                if(canVisit[loc.y][nextX] == true){
                    bfs.offer(new Loc(loc.y, nextX, loc.time + 1));
                    canVisit[loc.y][nextX] = false;
                }
            }
            
        }
        
        
        return -1;
    }
    
    class Loc{
        int y;
        int x;
        int time;
        
        Loc(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}