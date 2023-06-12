class Solution {
    public int[] solution(int[] emergency) {
        int[][] arr = new int[emergency.length][2];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = i + 1;
            arr[i][1] = emergency[i];
        }
        boolean nf = true;
        while(nf){
            nf = false;
            for(int i = 1; i < arr.length; i++){
                if(arr[i - 1][1] < arr[i][1]){
                    int temp = arr[i][1];
                    arr[i][1] = arr[i - 1][1];
                    arr[i - 1][1] = temp;
                    nf = true;
                }
            }            
        }
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(emergency[i] == arr[j][1]){
                    answer[i] = arr[j][0];
                }
            }
        }
        return answer;
    }
}