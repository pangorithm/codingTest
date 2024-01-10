import java.util.*;

class Solution {
    int[][] dices;
    boolean[] aSelected;
    int[] diceResults;
    int half;
    int length;
    int[] aScoreArr;
    int[] bScoreArr;
    int maxWinCount;
    int[] answer;
    int aIndex = 0;
    int bIndex = 0;
    
    public int[] solution(int[][] dice) {
        dices = dice;
        aSelected = new boolean[dice.length];
        diceResults = new int[dice.length];
        half = dice.length >> 1;
        length = 1;
        for(int i = 0; i < half; i++){
            length *= 6;
        }
        aScoreArr = new int[length];
        bScoreArr = new int[length];
        maxWinCount = 0;
        
        answer = new int[half];
        selectDices(0, 0);
        
        return answer;
    }
    
    private void selectDices(int count, int dept){
        if(count == half){
            aIndex = 0;
            bIndex = 0;
            int[] aDices = new int[half];
            int[] bDices = new int[half];
            int ai = 0;
            int bi = 0;
            for(int i = 0; i < dices.length; i++){
                if(aSelected[i]){
                    aDices[ai++] = i;
                } else {
                    bDices[bi++] = i;
                }
            }
            
            getDiceResults(0, aDices, new int[half], bDices, new int[half]);
            Arrays.sort(aScoreArr);
            Arrays.sort(bScoreArr);
            
            int winCount = 0;
            aIndex = 0;
            bIndex = 0;
            while(aIndex < length){
                while(bIndex < length && aScoreArr[aIndex] > bScoreArr[bIndex]){
                    bIndex++;
                }
                winCount += bIndex;
                aIndex++;
            }
            if(maxWinCount < winCount){
                maxWinCount = winCount;
                int index = 0;
                for(int i = 0; i < dices.length; i++){
                    if(aSelected[i]){
                        answer[index++] = i + 1;
                    }
                }
            }
            
        } else {
            count++;
            for(int i = dept; i < dices.length; i++){
                aSelected[i] = true;
                selectDices(count, i + 1);
                aSelected[i] = false;
            }
            
        }
    }
    
    private void getDiceResults(int dept, int[] aDices, int[] aResults, int[] bDices, int[] bResults){        
        if(dept == half){
            int aScore = 0;
            int bScore = 0;
            
            for(int i = 0; i < half; i++){
                aScore += aResults[i];
                bScore += bResults[i];
            }
            aScoreArr[aIndex++] = aScore;
            bScoreArr[bIndex++] = bScore; 
            
        } else {
            for(int i = 0; i < 6; i++){
                aResults[dept] = dices[aDices[dept]][i];
                bResults[dept] = dices[bDices[dept]][i];
                getDiceResults(dept + 1, aDices, aResults, bDices, bResults);
            }
        }
    }
        
}