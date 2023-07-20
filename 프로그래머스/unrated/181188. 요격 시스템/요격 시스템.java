import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (v1, v2) -> v1[1] - v2[1]); // 미사일 착탄지점 기준 정렬
        int answer = 0;
        int cursor = 0; // 요격 시스템 위치
        
        for(int[] target : targets){
            if(target[0] < cursor){ // 현재 요격시스템 위치에서 해결 가능할 경우
                continue;
            } else { // 그렇지 않을 경우 요격 시스템 범위 추가
                cursor = target[1];
                answer++;
            }
        }
                
        return answer;
    }
}