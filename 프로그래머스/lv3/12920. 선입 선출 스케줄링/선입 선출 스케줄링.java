import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int maxWorkTime = 0; // 가장 오래 걸리는 core의 작업시간
        for(int i = 0; i < cores.length; i++){
            if(maxWorkTime < cores[i]){
                maxWorkTime = cores[i];
            }
        }
        
        int maxTime = n * maxWorkTime / cores.length; // 가장 오래 걸리는 코어기준으로 작업 시 걸리는 시간
        int minTime = 0;
        
        while(minTime < maxTime){
            int time = (maxTime + minTime) >> 1;
            
            int workCount = 0; // 해당 시간에 마쳤거나 진행중인 작업 개수
            ArrayList<Integer> list = new ArrayList<Integer>(); // 해당 시간에 작업을 마친 코어 리스트
            for(int i = 0; i < cores.length; i++){
                // 해당 시간에 작업이 안끝난 경우 작업 점유중 && 작업을 마쳤을 경우 바로 새 작업을 받아서 작업 점유
                // 따라서 어떤 경우이든 항상 작업을 점유중이므로 +1
                workCount += time / cores[i] + 1;
                if(time % cores[i] == 0){
                    list.add(i);
                }
            }
            
            // int startedWorkCount = workCount - list.size(); // 해당 시간 이전에 시작된 작업의 수
            
            if(workCount < n){ // 작업시간 부족
                minTime = time;
            } else if(n <= workCount - list.size()){ // 이전 시간에 이미 모든 작업을 마쳤음
                maxTime = time;
            } else {
                // 전체 작업 수 - 직전 시간에 마치거나 점유한 작업 수 == 해당 시간에 점유하는 작업의 수
                // 인덱스가 0부터 시작이므로 -1
                return list.get(n - (workCount - list.size()) - 1) + 1; // core 번호가 0이 아니라 1부터 이므로 +1
            }
            
        }
        
        return -1;
    }
}