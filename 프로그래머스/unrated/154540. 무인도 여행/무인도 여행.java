import java.util.*;

class Solution {
    static int index = 1;
    public int[] solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        int[][] mapNum = new int[maps.length][maps[0].length()];
        ArrayList<Integer> list  = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        
        Stack<State> dfs = new Stack<>();
        
        for(int y = 0; y < map.length; y++){
            for(int x = 0; x < map[0].length; x++){
                if(map[y][x] != 'X' && mapNum[y][x] == 0){
                    // System.out.println(y+","+ x+"이게 맞아?");
                    dfs.push(new State(y, x));
                    while(!dfs.empty()){
                        State state = dfs.pop();
                        if(mapNum[state.y][state.x] == 0){
                            checkIndex(state.y, state.x, map, mapNum, list);
                            // System.out.println(state.y+","+ state.x+":"+mapNum[state.y][state.x]);

                            for(State nextState : getNextStates(state, map, mapNum)){
                                if(nextState != null){
                                    dfs.push(nextState);
                                }
                            }
                        }
                    }
                }
            }
        }     
            
        if(list.size() == 0){
            int[] answer = {-1};
            return answer;
        }
        
        Integer[] temp = list.toArray(new Integer[0]);
        Arrays.sort(temp);
        int[] answer = new int[temp.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = temp[i];
        }
        
        return answer;
    }
    
    void checkIndex(int y, int x, char[][] map, int[][] mapNum, ArrayList<Integer> list){
        if(mapNum[y][x] == 0 && map[y][x] != 'X'){
            if(y > 0 && mapNum[y - 1][x] > 0){
                mapNum[y][x] = mapNum[y - 1][x];
                list.set(mapNum[y - 1][x] - 1, list.get(mapNum[y - 1][x] - 1) + map[y][x] - '0');
                return;
            }
            if(x > 0 && mapNum[y][x - 1] > 0){
                mapNum[y][x] = mapNum[y][x - 1];
                list.set(mapNum[y][x - 1] - 1, list.get(mapNum[y][x - 1] - 1) + map[y][x] - '0');
                return;
            }
            if(y + 1 < mapNum.length && mapNum[y + 1][x] > 0){
                mapNum[y][x] = mapNum[y + 1][x];
                list.set(mapNum[y + 1][x] - 1, list.get(mapNum[y + 1][x] - 1) + map[y][x] - '0');
                return;
            }
            if(x + 1 < mapNum[0].length && mapNum[y][x + 1] > 0){
                mapNum[y][x] = mapNum[y][x + 1];
                list.set(mapNum[y][x + 1] - 1, list.get(mapNum[y][x + 1] - 1) + map[y][x] - '0');
                return;
            }
            mapNum[y][x] = index++;
            list.add(map[y][x] - '0');
        }
    }
    
    State[] getNextStates(State state, char[][] map, int[][] mapNum){
        State[] nextStates = new State[4];
        int y = state.y;
        int x = state.x;
        if(y > 0 && map[y - 1][x] != 'X' && mapNum[y - 1][x] == 0){
            nextStates[0] = new State(y - 1, x);
        }
        if(x > 0 && map[y][x - 1] != 'X' && mapNum[y][x - 1] == 0){
            nextStates[1] = new State(y, x - 1);
        }
        if(y + 1 < map.length && map[y + 1][x] != 'X' && mapNum[y + 1][x] == 0){
            nextStates[2] = new State(y + 1, x);
        }
        if(x + 1 < map[0].length && map[y][x + 1] != 'X' && mapNum[y][x + 1] == 0){
            nextStates[3] = new State(y, x + 1);
        }
        return nextStates;
    }
    
    class State {
        int y;
        int x;
        
        State(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}