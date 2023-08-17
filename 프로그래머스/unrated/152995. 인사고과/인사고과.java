import java.util.*;

class Solution {
    public int solution(int[][] scores) {

        int[] wanHo = scores[0];
        Arrays.sort(scores, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);
        // 태도점수를 내림차순 정렬, 태도점수가 같을 경우 동료평가 점수를 오름차순 정렬

        int answer = 1, maxReviewScore = 0, wanHoSum = wanHo[0] + wanHo[1];

        for (int[] score : scores) {
            if (score[1] < maxReviewScore) {
                // 태도점수 내림차순 정렬되었으므로 태도 점수는 이전보다 무조건 낮음
                // 태도점수가 같을 경우 동료평가 점수는 오름차순 정렬이므로 순회시 최대 동료 평가 점수보다 낮을일이 없음
                // 지금까지의 최대 동료평가 점수 보다 낮을경우 태도, 평가 둘다 낮으므로 인센티브를 못 받음
                if (score.equals(wanHo)){ // 그게 완호일 경우
                    return -1;
                }
            } else {
                maxReviewScore = Math.max(maxReviewScore, score[1]); // 지금까지의 최대 동료평가 점수 기록
                if (score[0] + score[1] > wanHoSum){ // 점수 합이 완호의 점수합보다 클 경우 완호의 순위 1개 하락
                    answer++;
                }
            }
        }
        return answer;
    }
}