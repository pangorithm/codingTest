class Solution {
    public int[][] solution(int[][] arr) {
        int length = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[length][length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}