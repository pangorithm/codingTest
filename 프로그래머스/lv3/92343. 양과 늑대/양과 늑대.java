class Solution {         
    static int n;
    static int[] animal;
    static int[] l; // 왼쪽 자식노드
    static int[] r; // 오른쪽 자식노드
    static boolean[] visited; // 비트마스크를 이용한 방문 상태 정의
    static int answer = 1;
    
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        animal = info;
        l = new int[n];
        r = new int[n];
        visited = new boolean[1 << n];
        
        
        for(int i = 0; i < edges.length; i++){
            int p = edges[i][0]; // 부모
            int c = edges[i][1]; // 자식
            if(l[p] == 0) { // 자식노드가 초기상태 == 자식노드가 루트노드 == 자식노드가 없음
                l[p] = c;
            } else {
                r[p] = c;
            }
        }
        
        // 00000000000000001 == 0번 노드만 포함된 상태에서 dfs 시작
        dfs(1);
        
        return answer;
    }
    
    // 상태 dfs 탐색
    private void dfs(int state){
        if(visited[state]){
            return;
        }
        visited[state] = true;
        
        // wolf : 늑대의 수, num : 전체 정점의 수
        int wolf = 0, num = 0;
        for(int i = 0; i < n; i++){
            if((state & (1 << i)) != 0){ // 비트마스크를 이용해 해당 상태에 i번 노드가 포함되어 있는지 확인
                num++;
                wolf += animal[i]; // i번 노드가 늑대일 경우 1 증가
            }
        }
        
        // 만약 늑대가 절반 이상일 경우 방문할 수 없는 상태이니 종료
        if((wolf << 1) >= num){
            return;
        }
        
        // 현재 state의 양의 수가 ans보다 클 경우 ans를 갱신
        answer = Math.max(answer, num - wolf);
        
        // 다음 상태로 전이
        for(int i = 0; i < n; i++){
            // 비트마스크를 이용해 해당 상태에 i번 노드가 포함되어 있는지 확인
            if((state & (1 << i)) == 0){ // 현재 상태에 i번 노드가 포함되지 않았을 경우 스킵
                continue;
            }
            // 현재 보고 있는 i번째 노드의 left 자식 노드 존재
            if(l[i] != 0){
                dfs(state | (1 << l[i])); // 현재 상태에 i번째 노드의 left 자식 노드 추가 후 다음 상태 탐색
            }
            // 현재 보고 있는 i번째 노드의 right 자식 노드 존재
            if(r[i] != 0){
                dfs(state | (1 << r[i])); // 현재 상태에 i번째 노드의 right 자식 노드 추가 후 다음 상태 탐색
            }
        }
    }
}