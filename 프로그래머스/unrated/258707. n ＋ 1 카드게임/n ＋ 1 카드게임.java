import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        
        Set<Integer> handCardSet = new HashSet<>();
        Set<Integer> coinCardSet = new HashSet<>();
        
        int handCardCount = cards.length / 3;
        int index = 0;
        while(index < handCardCount){
            handCardSet.add(cards[index++]);
        }
        
        int target = cards.length + 1;
        int round = 0;
        while(true){
            round++;
            
            if(index + 2 > cards.length){
                break;
            }
            coinCardSet.add(cards[index++]);
            coinCardSet.add(cards[index++]);            
            
            boolean hasPair = false;
            if(!hasPair){
                for(int card : handCardSet){
                    int pairCard = target - card;
                    if(handCardSet.contains(pairCard)){
                        handCardSet.remove(card);
                        handCardSet.remove(pairCard);
                        hasPair = true;
                        break;
                    }
                }
            }
            
            if(!hasPair && coin >= 1){
                for(int card : handCardSet){
                    int pairCard = target - card;
                    if(coinCardSet.contains(pairCard)){
                        handCardSet.remove(card);
                        coinCardSet.remove(pairCard);
                        hasPair = true;
                        coin--;
                        break;
                    }
                }
            }
            
            if(!hasPair && coin >= 2){
                for(int card : coinCardSet){
                    int pairCard = target - card;
                    if(coinCardSet.contains(pairCard)){
                        coinCardSet.remove(card);
                        coinCardSet.remove(pairCard);
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