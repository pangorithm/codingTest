import java.util.*;

class Solution {
    static HashMap<String, String> enToReMap; // <enroll, referral>
    static HashMap<String, Integer> sellerMap; // <seller, answerIndex>
    static int[] answer;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        enToReMap = new HashMap<String, String>();
        sellerMap = new HashMap<String, Integer>(); 
        answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++){
            enToReMap.put(enroll[i], referral[i]);
            sellerMap.put(enroll[i], i);
        }
        
        for(int i = 0; i < seller.length; i++){
            settleProfit(seller[i], amount[i] * 100);
        }
        
        return answer;
    }
    
    private void settleProfit(String seller, int profit){
        if(profit < 10){
            answer[sellerMap.get(seller)] += profit;
        } else {
            if(enToReMap.get(seller).equals("-")){
                answer[sellerMap.get(seller)] += (profit - profit / 10);
            } else {
                answer[sellerMap.get(seller)] += (profit - profit / 10);
                settleProfit(enToReMap.get(seller), profit / 10);
            }            
        }
    }
}