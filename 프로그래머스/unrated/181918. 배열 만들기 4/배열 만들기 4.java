class Solution {
    public int[] solution(int[] arr) {
        int[] temp = new int[arr.length];
        int count = 0;
        for(int i = 0; i < arr.length;){
            if(temp[0] == 0){
                temp[count++] = arr[i++];
            } else if(temp[count - 1] < arr[i]){
                temp[count++] = arr[i++];
            } else {
                temp[--count] = 0;
            }
        }
        int[] stk = new int[count];
        for(int i = 0; i < count; i++){
            stk[i] = temp[i];
        }
        return stk;
    }
}