class Solution {
    public int[] solution(int[] arr, int n) {
        if((arr.length & 1) == 1){
            for(int i = 0; i < arr.length;){
                arr[i] += n;
                i = i + 2;
            }
        } else {
            for(int i = 1; i < arr.length;){
                arr[i] += n;
                i = i + 2;
            }
        }
        return arr;
    }
}