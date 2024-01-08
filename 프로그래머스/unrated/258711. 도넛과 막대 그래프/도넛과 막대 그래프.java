import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        ArrayList<Integer>[] graph = new ArrayList[1_000_001];
        for(int i = 1; i <= 1_000_000; i++){
            graph[i] = new ArrayList<>();
        }
        int[] inCounts = new int[1_000_001];
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            inCounts[edge[1]]++;
        }
        
        int[] answer = new int[4]; // { 정점 번호, 도넛, 막대, 8자 }
        for(int i = 1; i <= 1_000_000; i++){
            if(inCounts[i] == 0 && graph[i].size() >= 2){
                answer[0] = i;
                break;
            }
        }
        for(int startNode : graph[answer[0]]){
            inCounts[startNode]--;
        }

        for(int startNode : graph[answer[0]]){
            int outCount = graph[startNode].size();
            if(outCount == 0){
                answer[2]++;
                continue;
            }
            if(outCount == 2 && inCounts[startNode] == 2){
                answer[3]++;
                continue;
            }  
            
            int node = graph[startNode].get(0);
            while(true) {
                outCount = graph[node].size();
                if(outCount == 0){
                    answer[2]++;
                    break;
                } else if(outCount == 2 && inCounts[node] == 2){
                    answer[3]++;
                    break;
                } else if(node == startNode){
                    answer[1]++;
                    break;
                }
                node = graph[node].get(0);
            }
        }
        
        return answer;
    }
}