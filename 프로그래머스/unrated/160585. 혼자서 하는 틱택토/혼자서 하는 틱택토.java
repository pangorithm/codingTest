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
        set.add(new StringBuilder().append(table[0][0]).append(table[0][1]).append(table[0][2]).toString());
        set.add(new StringBuilder().append(table[1][0]).append(table[1][1]).append(table[1][2]).toString());
        set.add(new StringBuilder().append(table[2][0]).append(table[2][1]).append(table[2][2]).toString());
        
        set.add(new StringBuilder().append(table[0][0]).append(table[1][0]).append(table[2][0]).toString());
        set.add(new StringBuilder().append(table[0][1]).append(table[1][1]).append(table[2][1]).toString());
        set.add(new StringBuilder().append(table[0][2]).append(table[1][2]).append(table[2][2]).toString());
        
        set.add(new StringBuilder().append(table[0][0]).append(table[1][1]).append(table[2][2]).toString());
        set.add(new StringBuilder().append(table[0][2]).append(table[1][1]).append(table[2][0]).toString());
        
        System.out.println(set);
        if(set.contains("OOO") && oMxCount == 0 || set.contains("XXX") && oMxCount == 1){
            return 0;
        }
        
        return 1;
    }
}