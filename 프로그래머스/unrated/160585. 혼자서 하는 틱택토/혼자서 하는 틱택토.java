import java.util.*;

class Solution {
    static char[][] table;
    public int solution(String[] board) {
        table = new char[3][3];
        int oCount = 0;
        int xCount = 0;
        for(int i = 0; i < 3; i++){
            table[i] = board[i].toCharArray();
            for(int j = 0; j < 3; j++){
                switch (table[i][j]){
                    case 'O': oCount++; break;
                    case 'X': xCount++; break;
                }
            }
        }
        
        int oMxCount = oCount - xCount;
        if(oMxCount < 0 || oMxCount > 1){
            return 0;
        }
        
        HashSet<String> set = new HashSet<>();
        StringBuilder str = new StringBuilder();
        str.append(table[0][0]).append(table[0][1]).append(table[0][2]);
        set.add(str.toString());
        str = new StringBuilder();
        str.append(table[1][0]).append(table[1][1]).append(table[1][2]);
        set.add(str.toString());
        str = new StringBuilder();
        str.append(table[2][0]).append(table[2][1]).append(table[2][2]);
        set.add(str.toString());
        
        str = new StringBuilder();
        str.append(table[0][0]).append(table[1][0]).append(table[2][0]);
        set.add(str.toString());
        str = new StringBuilder();
        str.append(table[0][1]).append(table[1][1]).append(table[2][1]);
        set.add(str.toString());
        str = new StringBuilder();
        str.append(table[0][2]).append(table[1][2]).append(table[2][2]);
        set.add(str.toString());
        
        str = new StringBuilder();
        str.append(table[0][0]).append(table[1][1]).append(table[2][2]);
        set.add(str.toString());
        str = new StringBuilder();
        str.append(table[0][2]).append(table[1][1]).append(table[2][0]);
        set.add(str.toString());
        
        System.out.println(set);
        if(set.contains("OOO") && oMxCount == 0){
            return 0;
        }
        if(set.contains("XXX") && oMxCount == 1){
            return 0;
        }
        
        return 1;
    }
}