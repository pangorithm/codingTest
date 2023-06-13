class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = -1;
        }
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            boolean flag = true;
            for(int j = 0; j < k; j++){
                if(arr[i] == answer[j]){
                    flag = false;
                    continue;
                }
            }
            if(flag){
                answer[index++] = arr[i];
                if(index == k){
                    break;
                }
            }
        }
        return answer;
    }
}