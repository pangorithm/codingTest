class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;
        for(int i = 0; i < query.length; i++){
            if((i & 1) == 0){
                int[] temp = new int[query[i] + 1];
                for(int j = 0; j < temp.length; j++){
                    temp[j] = answer[j];
                }
                answer = temp;
            } else {
                int[] temp = new int[answer.length - query[i]];
                for(int j = 0; j < temp.length; j++){
                    temp[j] = answer[query[i] + j];
                }
                answer = temp;
            }
        }
        return answer;
    }
}