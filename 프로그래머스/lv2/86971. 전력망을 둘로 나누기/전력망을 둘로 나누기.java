import java.util.*;

class Solution {    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++){
            int result = getResult(i, wires);
            if(result < answer){
                answer = result;
            }
        }
        return answer;
    }
    
    int getResult(int index, int[][] wires){
        HashSet<Integer> tree1 = new HashSet<>();
        tree1.add(wires[index][0]);
        HashSet<Integer> tree2 = new HashSet<>();
        tree2.add(wires[index][1]);
        
        Queue<Integer[]> que = new LinkedList<>();
        for(int i = 0; i < wires.length; i++){
            if(i == index){
                continue;
            }
            Integer[] temp = new Integer[2];
            temp[0] = wires[i][0];
            temp[1] = wires[i][1];
            que.offer(temp);
        }
        
        while(que.size() != 0){
            Integer[] wire = que.poll();
            if(tree1.contains(wire[0]) || tree1.contains(wire[1])){
                tree1.add(wire[0]);
                tree1.add(wire[1]);
                continue;
            }            
            if(tree2.contains(wire[0]) || tree2.contains(wire[1])){
                tree2.add(wire[0]);
                tree2.add(wire[1]);
                continue;
            }
            que.offer(wire);
        }
        return Math.abs(tree1.size() - tree2.size());
    }    
}