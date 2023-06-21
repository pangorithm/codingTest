import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        for(int i = 0; i < score.length / m; i++){
            answer += score[score.length - (m * (i + 1))] * m;
        }
        return answer;
    }
}