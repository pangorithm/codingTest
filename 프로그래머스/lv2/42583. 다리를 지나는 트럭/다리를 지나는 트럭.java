import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        int time = 1;
        int index = 1;
        bridge.offer(new Truck(truck_weights[0], 1));
        int sum = truck_weights[0];
        while(bridge.size() > 0){
            time++;
            if(bridge.peek().inTime + bridge_length == time){
                sum -= bridge.poll().weight;
            }
            if(index < truck_weights.length){
                if(sum + truck_weights[index] <= weight && bridge.size() <= bridge_length){                
                    bridge.offer(new Truck(truck_weights[index], time));
                    sum += truck_weights[index++];
                }
            }
        }
        return time;
    }
    
    class Truck {
        int weight;
        int inTime;
        
        Truck(int weight, int inTime){
            this.weight = weight;
            this.inTime = inTime;
        }
    }
}