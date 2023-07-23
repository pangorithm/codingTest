// import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliveriesSum = 0;
        int deliveriesLastIndex = -1;
        int pickupsSum = 0;
        int pickupsLastIndex = -1;
        for(int i = 0; i < n; i++){
            if(deliveries[i] > 0){
                deliveriesSum += deliveries[i];
                deliveriesLastIndex = i;
            }
            if(pickups[i] > 0){
                pickupsSum += pickups[i];
                pickupsLastIndex = i;
            }            
        }        
        
        long answer = 0;
        int truck;
        while(deliveriesSum > 0 || pickupsSum > 0){
            // System.out.println(deliveriesLastIndex +" "+ pickupsLastIndex);
            answer += (long) Math.max(deliveriesLastIndex, pickupsLastIndex) + 1;         
    
            truck = cap; // 배달할 상자 갯수
            deliveriesSum -= cap;
            for(int i = deliveriesLastIndex; i >= 0; i--){
                if(deliveries[i] > 0){
                    if(deliveries[i] > truck){
                        deliveries[i] -= truck;
                        truck = 0;
                        deliveriesLastIndex = i;
                        break;
                    } else {
                        truck -= deliveries[i];
                        deliveries[i] = 0;
                    }
                }
            }
            if(deliveriesSum <= 0){
                deliveriesLastIndex = -1;
            }
            
            truck = cap; // 수거 가능 상자 갯수
            pickupsSum -= cap;
            for(int i = pickupsLastIndex; i >= 0; i--){
                if(pickups[i] > 0){
                    if(pickups[i] <= truck){
                        truck -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= truck;
                        truck = 0;
                        pickupsLastIndex = i;
                        break;
                    }
                }
            }
            if(pickupsSum <= 0){
                pickupsLastIndex = -1;
            }
            
            // System.out.println(Arrays.toString(deliveries));
            // System.out.println(Arrays.toString(pickups));
            // System.out.println("");
        }
        
        return answer << 1;
    }
}