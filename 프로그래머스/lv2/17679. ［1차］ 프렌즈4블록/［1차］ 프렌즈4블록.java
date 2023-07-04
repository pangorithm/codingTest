import java.util.HashSet;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] boardArr = new char[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++){
            boardArr[i] = board[i].toCharArray();
        }
        boolean notFinish = true;
        while(notFinish){
            notFinish = false;
            
            // 블록 점검
            HashSet<Loc> set = new HashSet<>();
            for(int y = 1; y < boardArr.length; y++){
                for(int x = 1; x < boardArr[0].length; x++){
                    if(boardArr[y][x] != ' '
                      && boardArr[y][x] == boardArr[y - 1][x]
                      && boardArr[y][x] == boardArr[y][x - 1]
                      && boardArr[y][x] == boardArr[y - 1][x - 1]){
                        set.add(new Loc(y, x));
                        notFinish = true;
                    }
                }
            }
            
            // 블록 삭제
            if(notFinish){
                Loc[] arr = new Loc[set.size()];
                set.toArray(arr);
                for(Loc loc : arr){
                    if(boardArr[loc.y][loc.x] != ' '){
                        boardArr[loc.y][loc.x] = ' ';
                        answer++;
                    }
                    if(boardArr[loc.y - 1][loc.x] != ' '){
                        boardArr[loc.y - 1][loc.x] = ' ';
                        answer++;
                    }
                    if(boardArr[loc.y][loc.x - 1] != ' '){
                        boardArr[loc.y][loc.x - 1] = ' ';
                        answer++;
                    }
                    if(boardArr[loc.y - 1][loc.x - 1] != ' '){
                        boardArr[loc.y - 1][loc.x - 1] = ' ';
                        answer++;
                    }
                }
            }
            
            // 블록 아래로 이동
            for(int x = 0; x < boardArr[0].length; x++){ 
                for(int y = boardArr.length - 1; y > 0; y--){
                    if(boardArr[y][x] == ' '){
                        for(int i = y - 1; i > -1 ; i--){
                            if(boardArr[i][x] != ' '){
                                boardArr[y][x] = boardArr[i][x];
                                boardArr[i][x] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    class Loc {
        int x;
        int y;
        
        Loc(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}