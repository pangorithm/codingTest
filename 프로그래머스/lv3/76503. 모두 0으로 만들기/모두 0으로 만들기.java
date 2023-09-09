import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        for(int v : a){
            sum += v;
        }
        if(sum != 0){
            return -1l;
        }
        
        long[] v = new long[a.length];
        for(int i = 0; i < a.length; i++){
            v[i] = a[i];
        }
        
        HashSet<Integer>[] lists = new HashSet[a.length];
        for(int i = 0; i < a.length; i++){
            lists[i] = new HashSet<Integer>();
        }
        
        for(int[] e : edges){
            lists[e[0]].add(e[1]);
            lists[e[1]].add(e[0]);
        }
        
        long answer = 0;
        
        Stack<Integer> endNodeStack = new Stack<>();
        for(int i = 0; i < lists.length; i++){
            if(lists[i].size() == 1){
                endNodeStack.push(i);
            }            
            
            while(!endNodeStack.empty()){
                Integer node = endNodeStack.pop();
                Integer nextNode = lists[node].toArray(new Integer[1])[0];
                lists[node].clear();

                if(v[node] != 0){
                    v[nextNode] += v[node];
                    answer += Math.abs(v[node]);
                }
                lists[nextNode].remove(node);

                if(lists[nextNode].size() == 1){
                    endNodeStack.push(nextNode);
                }            
            }
        }
        
        return answer;
    }
    
    class Node {
        long v;
        ArrayList<Node> list = new ArrayList<>();
        
        Node(int v){
            this.v = v;
        }
    }
}