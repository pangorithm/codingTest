import java.util.*;

class Solution {
    static ArrayList<Edge>[] graph; // 그래프 배열의 i번째 원소 == i번째 노드와 연결된 간선 리스트
    static int[] dp; // 해당 노드에 도착 가능한 최소 intensity 메모
    static HashSet<Integer> summitSet; // 정상 확인용 집합
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){ // 간선 리스트 초기화
            graph[i] = new ArrayList<>();
        }
        for(int[] path : paths){ // 그래프 완성하기
            graph[path[0]].add(new Edge(path[1], path[2]));
            graph[path[1]].add(new Edge(path[0], path[2]));
        }
        
        dp = new int[n + 1]; // intensity 메모 초기화
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        summitSet = new HashSet<>(); // 정상 집합 초기화
        for(int summit : summits){
            summitSet.add(summit);
        }
        
        // 다익스트라 탐색에 사용할 노드 번호 우선순위 큐
        // intensity가 가장 작은 노드부터 다익스트라 탐색
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            int temp = dp[n1] - dp[n2];
            if(temp == 0){
                return n1 - n2;
            }
            return temp;
        });
        
        for(int gate : gates){ // 게이트의 가중치는 0
            dp[gate] = 0;
            pq.add(gate); // 우선 순위 큐에 입구를 추가함으로써 다익스트라 탐색 준비
        }
        
        while(pq.size() > 0){
            int node = pq.poll();
            if(pq.size() > 0 && node == pq.peek()){
                continue;
            }
            
            for(Edge edge : graph[node]){ // 해당 노드에 연결된 간선들 탐색
                int nextW = Math.max(dp[node], edge.w); // 간선으로 연결된 노드의 가중치
                if(nextW < dp[edge.dst]){ // 목적지 노드의 intensity가 더 큰 경우 추가 탐색
                    dp[edge.dst] = nextW;
                    if(!summitSet.contains(edge.dst)){ // 정상이 아닌 경우에만 추가 탐색
                        pq.add(edge.dst);
                    }
                }
            }
        }
        
        int[] answer = new int[] {0, Integer.MAX_VALUE};
        Arrays.sort(summits); // 정상 번호가 낮은 등산 코스를 리턴하기 위한 정렬
        for(int summit : summits){
            if(dp[summit] < answer[1]){
                answer[0] = summit;
                answer[1] = dp[summit];
            }
        }
        return answer;
    }
    
    private class Edge{
        int dst;
        int w;
        
        Edge(int destination, int weight){
            this.dst = destination;
            this.w = weight;
        }
    }
}