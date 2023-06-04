class Solution {
    public int solution(int[] array) {
        int[] big_count = new int[array.length];
        int[] small_count = new int[array.length];
        int answer = 0;
        for(int i = 0; i < array.length; i++){
            big_count[i] = 0;
            small_count[i] = 0;
            for(int j = 0; j < array.length; j++){
                if(array[j] > array[i]){
                    big_count[i]++;
                }
                if(array[j] < array[i]){
                    small_count[i]++;
                }                
            }
            if(!(big_count[i] > (array.length >> 1)) && !(small_count[i] > (array.length >> 1))){
                answer = array[i];
                break;
            }
        }
        return answer;
    }
}