class Solution {
    public int solution(int[] arr) {
        int count = 0;
        while(true){
            int eqc = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] >= 50 && (arr[i] & 1) == 0){
                    arr[i] = arr[i] >> 1;
                } else if(arr[i] < 50 && (arr[i] & 1) == 1){
                    arr[i] = (arr[i] << 1) + 1;
                } else {
                    eqc++;
                }
            }
            if(eqc == arr.length){
                return count;
            }
            count++;
        }
    }
}