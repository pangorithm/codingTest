import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        for(int y = 0; y < map.length; y++){
            for(int x = 0; x < map[0].length; x++){
                switch(map[y][x]){
                    case 'S':
                        start[0] = y;
                        start[1] = x;
                        break;
                    case 'L':
                        lever[0] = y;
                        lever[1] = x;
                        break;
                    case 'E':
                        exit[0] = y;
                        exit[1] = x;
                        break;
                }
            }
        }
        int answer = 0;
        
        visited = new boolean[map.length][map[0].length];
        int time = getTime(start, lever);        
        if(time == -1){
            return -1;
        }
        answer += time;
        
        visited = new boolean[map.length][map[0].length];
        time = getTime(lever, exit);
        if(time == -1){
            return -1;
        }        
        answer += time;
        
        return answer;
    }
    
    private int getTime(int[] from, int[] to){
        int[] move = new int[] {-1, 1};
        Queue<Loc> bfs = new ArrayDeque<>();
        bfs.offer(new Loc(from[0], from[1], 0));
        while(bfs.size() > 0){
            Loc loc = bfs.poll();
            if(loc.y == to[0] && loc.x == to[1]){
                return loc.time;
            }
            
            for(int m : move){
                int nextY = loc.y + m;
                int nextX = loc.x + m;
                if(nextY >= 0 && nextY < map.length && map[nextY][loc.x] != 'X' && visited[nextY][loc.x] == false){
                    bfs.offer(new Loc(nextY, loc.x, loc.time + 1));
                    visited[nextY][loc.x] = true;
                }
                if(nextX >= 0 && nextX < map[0].length && map[loc.y][nextX] != 'X' && visited[loc.y][nextX] == false){
                    bfs.offer(new Loc(loc.y, nextX, loc.time + 1));
                    visited[loc.y][nextX] = true;
                }
            }
        }
        return -1;
    }
    
    class Loc {
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