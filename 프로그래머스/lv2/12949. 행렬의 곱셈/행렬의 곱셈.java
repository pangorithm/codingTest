class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                for(int count = 0; count < arr2.length; count++){
                    answer[i][j] += arr1[i][count] * arr2[count][j];
                }
            }
        }
        return answer;
    }
}