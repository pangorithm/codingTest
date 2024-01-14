import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        
        Set<Integer> handsCardSet = new TreeSet<>();
        Set<Integer> dumpCardSet = new TreeSet<>();
        
        int quarterN = cards.length / 3;
        int index = 0;
        while(index < quarterN){
            handsCardSet.add(cards[index++]);
        }
        
        int target = cards.length + 1;
        int round = 0;
        while(true){
            round++;
            
            if(index + 2 > cards.length){
                break;
            }
            dumpCardSet.add(cards[index++]);
            dumpCardSet.add(cards[index++]);            
            
            boolean hasPair = false;
            if(!hasPair){
                for(int card : handsCardSet){
                    int pairCard = target - card;
                    if(handsCardSet.contains(pairCard)){
                        handsCardSet.remove(card);
                        handsCardSet.remove(pairCard);
                        hasPair = true;
                        break;
                    }
                }
            }
            
            if(!hasPair && coin >= 1){
                for(int card : handsCardSet){
                    int pairCard = target - card;
                    if(dumpCardSet.contains(pairCard)){
                        handsCardSet.remove(card);
                        dumpCardSet.remove(pairCard);
                        hasPair = true;
                        coin--;
                        break;
                    }
                }
            }
            
            if(!hasPair && coin >= 2){
                for(int card : dumpCardSet){
                    int pairCard = target - card;
                    if(dumpCardSet.contains(pairCard)){
                        dumpCardSet.remove(card);
                        dumpCardSet.remove(pairCard);
                        hasPair = true;
                        coin -= 2;
                        break;
                    }
                }
            }
            
            if(!hasPair){
               break; 
            }
        }
        
        return round;
    }
}