class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int imin = Integer.MAX_VALUE;
            for(int j = queries[i][0]; j < queries[i][1] + 1; j++){
                if(imin > arr[j] && arr[j] > queries[i][2]){
                    imin = arr[j];
                }
            }
            answer[i] = (imin == Integer.MAX_VALUE) ? -1 : imin;
        }
        return answer;
    }
}