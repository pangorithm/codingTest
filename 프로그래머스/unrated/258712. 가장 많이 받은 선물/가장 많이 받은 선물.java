import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int n = friends.length;
        HashMap<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            indexMap.put(friends[i], i);
        }
        
        int[][] board = new int[n][n];
        for(String str : gifts){
            String[] gift = str.split(" ");
            int aIndex = indexMap.get(gift[0]);
            int bIndex = indexMap.get(gift[1]);
            board[aIndex][bIndex]++;
        }
        
        int[] giftPoint = new int[friends.length];
        for(int a = 0; a < n; a++){
            for(int b = a + 1; b < n; b++){
                int point = board[a][b] - board[b][a];
                giftPoint[a] += point;
                giftPoint[b] -= point;
            }
        }
        
        int[] nextGifts = new int[n];
        for(int a = 0; a < n; a++){
            for(int b = a + 1; b < n; b++){
                if(board[a][b] > board[b][a]){
                    nextGifts[a]++;
                } else if(board[a][b] < board[b][a]){
                    nextGifts[b]++;
                } else {
                    if(giftPoint[a] > giftPoint[b]){
                        nextGifts[a]++;
                    } else if(giftPoint[a] < giftPoint[b]){
                        nextGifts[b]++;
                    }
                }
            }
        }
        
        int max = 0;
        for(int ng : nextGifts){
            if(max < ng){
                max = ng;
            }
        }
        return max;
    }
}