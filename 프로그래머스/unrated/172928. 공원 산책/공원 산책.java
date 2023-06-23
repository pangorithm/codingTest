class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] location = new int[2]; // location[h][w] 
        char[][] map = new char[park.length][park[0].length()];
        loop : for(int h = 0; h < park.length; h++){
            char[] carr = park[h].toCharArray();
            map[h] = carr;
            for(int w = 0; w < carr.length; w++){
                if(carr[w] == 'S'){
                    location[0] = h;
                    location[1] = w;
                    // break loop; // char[][]를 만들기 위해 사용하지 않음
                    // bool 변수를 이용해서 S 발견 이후로는 내부 루프만 안돌게 할 수도 있음
                }
            }
        }
        // System.out.println(location[0] + " " + location[1]);
        loop : for(String route : routes){
            // String[] rt = route.split(" ");
            // int move = Integer.parseInt(rt[1]);
            int move = route.charAt(2) - '0';
            // System.out.println(move);
            switch (route.charAt(0)) {
                case 'E':
                    if(location[1] + move < map[0].length){
                        for(int i = location[1] + 1; i <= location[1] + move; i++){
                            if(map[location[0]][i] == 'X'){
                                continue loop;
                            }
                        }
                        location[1] += move;
                    }
                    break;
                case 'W':
                    if(location[1] - move > -1){
                        for(int i = location[1] - 1; i >= location[1] - move; i--){
                            if(map[location[0]][i] == 'X'){
                                continue loop;
                            }
                        }
                        location[1] -= move;
                    }
                    break;
                case 'S':
                    if(location[0] + move < map.length){
                        for(int i = location[0] + 1; i <= location[0] + move; i++){
                            if(map[i][location[1]] == 'X'){
                                continue loop;
                            }
                        }
                        location[0] += move;
                    }
                    break;
                case 'N':
                    if(location[0] - move > -1){
                        for(int i = location[0] - 1; i >= location[0] - move; i--){
                            if(map[i][location[1]] == 'X'){
                                continue loop;
                            }
                        }
                        location[0] -= move;
                    }
                    break;
            }
        }
        
        return location;
    }
}