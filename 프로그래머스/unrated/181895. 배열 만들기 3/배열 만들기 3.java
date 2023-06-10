class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int alength = intervals[0][1] - intervals[0][0] + 1;
        int blength = intervals[1][1] - intervals[1][0] + 1;
        int[] answer = new int[alength + blength];
        for(int i = 0; i < alength; i++){
            answer[i] = arr[intervals[0][0] + i];
        }for(int i = 0; i < blength; i++){
            answer[alength + i] = arr[intervals[1][0] + i];
        }
        return answer;
    }
}